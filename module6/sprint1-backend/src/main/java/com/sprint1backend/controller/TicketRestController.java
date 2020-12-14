package com.sprint1backend.controller;

import com.sprint1backend.entity.AppUser;
import com.sprint1backend.entity.FlightInformation;
import com.sprint1backend.entity.Passenger;
import com.sprint1backend.entity.Ticket;
import com.sprint1backend.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/edit/{ticket}/{passengerEdit}/{appUserID}")
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

    @GetMapping("/list-pending")
    public ResponseEntity<List<Ticket>> getListPendingTicket() {
        List<Ticket> ticketList = this.ticketService.findAllByStatusPaymentName(PENDING);
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }
}
