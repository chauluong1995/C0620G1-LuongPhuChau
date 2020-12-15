package com.sprint1backend.controller;

import com.sprint1backend.entity.*;
import com.sprint1backend.model.TicketDTO;
import com.sprint1backend.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.sprint1backend.common.AppUtils.PENDING;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> getListTicket() {
        List<Ticket> ticketList = this.ticketService.findAllTicket();
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Ticket> getTicketByID(@PathVariable Long id) {
        Ticket ticket = this.ticketService.findTicketByID(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/find-flight-information-by-id/{id}")
    public ResponseEntity<FlightInformation> getFlightInformationByID(@PathVariable Long id) {
        FlightInformation flightInformation = this.ticketService.findFlightInformationByID(id);
        return new ResponseEntity<>(flightInformation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ticket> deleteTicketByID(@PathVariable Long id) {
        this.ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/app-user/{emailInput}")
    public ResponseEntity<List<AppUser>> searchAppUserByEmail(@PathVariable String emailInput) {
        List<AppUser> appUserListExists = this.ticketService.findAllAppUser();
        List<AppUser> appUserListResult = new ArrayList<>();
        for (AppUser appUserExist : appUserListExists) {
            if (appUserExist.getEmail().equals(emailInput)) {
                appUserListResult.add(appUserExist);
            }
        }
        return new ResponseEntity<>(appUserListResult, HttpStatus.OK);
    }

    @GetMapping("/app-user-list")
    public ResponseEntity<List<AppUser>> getAllAppUser() {
        List<AppUser> appUserList = this.ticketService.findAllAppUser();
        return new ResponseEntity<>(appUserList, HttpStatus.OK);
    }

    @PutMapping("/edit/{ticket}/{passengerEdit}/{appUserID}")
    public ResponseEntity<Ticket> editTicket(@PathVariable Ticket ticket,
                                             @PathVariable String passengerEdit,
                                             @PathVariable Long appUserID) {
        ticket.setPassengerName(passengerEdit);
        List<AppUser> appUserList = this.ticketService.findAllAppUser();
        for (AppUser appUser : appUserList) {
            if (appUser.getId().equals(appUserID)) {
                ticket.setAppUser(appUser);
            }
        }
        this.ticketService.editTicket(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save/{idFlightInformationDeparture}/{idFlightInformationArrival}")
    public ResponseEntity<Ticket> saveTicket(@PathVariable Long idFlightInformationDeparture,
                                             @PathVariable Long idFlightInformationArrival,
                                             @RequestBody TicketDTO ticketDTO) {
        // Customer list analysis
        String passengers = ticketDTO.getPassengerName();
        String[] passengerList;
        passengerList = passengers.split(",");

        // Find flightInformationDeparture
        FlightInformation flightInformationDeparture;
        flightInformationDeparture = this.ticketService.findFlightInformationByID(idFlightInformationDeparture);

        // Find AppUser
        String email = ticketDTO.getAppUser();
        AppUser appUserCreate = null;
        List<AppUser> appUserList = this.ticketService.findAllAppUser();
        for (AppUser appUser : appUserList) {
            if (appUser.getEmail().equals(email)) {
                appUserCreate = appUser;
                break;
            }
        }

        // Find Employee
        Employee employeeCreate = null;
        List<Employee> employeeList = this.ticketService.findAllEmployee();
        for (Employee employee : employeeList) {
            if (employee.getId().equals(ticketDTO.getEmployee())) {
                employeeCreate = employee;
                break;
            }
        }

        // Create Booking
        Booking booking = new Booking();
        booking.setBookingCode(ticketDTO.getBooking());
        booking.setAppUser(appUserCreate);
        this.ticketService.saveBooking(booking);

        // Create Ticket Departure
        for (String passengerName : passengerList) {
            Ticket ticketDeparture = new Ticket();
            ticketDeparture.setPassengerName(passengerName);
            ticketDeparture.setStatusCheckin(false);
            String ticketCode = UUID.randomUUID().toString();
            ticketDeparture.setTicketCode(ticketCode);
            ticketDeparture.setPriceDeparture(ticketDTO.getPriceDeparture() / passengerList.length);
            ticketDeparture.setAppUser(appUserCreate);
            Booking bookingCreate = this.ticketService.findBookingByBookingCode(ticketDTO.getBooking());
            ticketDeparture.setBooking(bookingCreate);
            ticketDeparture.setEmployee(employeeCreate);
            ticketDeparture.setFlightInformation(flightInformationDeparture);
            this.ticketService.saveTicket(ticketDeparture);
        }

        // Create Ticket Arrival
        if (!idFlightInformationArrival.equals(0L)) {

            // Find flightInformationArrival
            FlightInformation flightInformationArrival;
            flightInformationArrival = this.ticketService.findFlightInformationByID(idFlightInformationArrival);

            for (String passengerName : passengerList) {
                Ticket ticketArrival = new Ticket();
                ticketArrival.setPassengerName(passengerName);
                ticketArrival.setStatusCheckin(false);
                String ticketCode = UUID.randomUUID().toString();
                ticketArrival.setPriceDeparture(ticketDTO.getPriceArrival() / passengerList.length);
                ticketArrival.setTicketCode(ticketCode);
                ticketArrival.setAppUser(appUserCreate);
                Booking bookingCreate = this.ticketService.findBookingByBookingCode(ticketDTO.getBooking());
                ticketArrival.setBooking(bookingCreate);
                ticketArrival.setEmployee(employeeCreate);
                ticketArrival.setFlightInformation(flightInformationArrival);
                this.ticketService.saveTicket(ticketArrival);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list-pending")
    public ResponseEntity<List<Ticket>> getListPendingTicket() {
        List<Ticket> ticketList = this.ticketService.findAllByStatusPaymentName(PENDING);
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }
}
