package com.sprint1backend.controller;

import com.sprint1backend.service.app_user.AppUserService;
import com.sprint1backend.service.booking.BookingService;
import com.sprint1backend.service.flight_information.FlightInformationService;
import com.sprint1backend.service.invoice.InvoiceService;
import com.sprint1backend.service.status_payment.StatusPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sprint1backend.entity.*;
import com.sprint1backend.model.TicketDTO;
import com.sprint1backend.service.ticket.TicketService;
import com.sprint1backend.service.email.EmailService;
import com.sprint1backend.service.employee.EmployeeService;

import static com.sprint1backend.common.AppUtils.PENDING;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightInformationService flightInformationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private StatusPaymentService statusPaymentService;

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
        FlightInformation flightInformation = this.flightInformationService.findFlightInformationByID(id);
        return new ResponseEntity<>(flightInformation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ticket> deleteTicketByID(@PathVariable Long id) {
        this.ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/app-user/{emailInput}")
    public ResponseEntity<List<AppUser>> searchAppUserByEmail(@PathVariable String emailInput) {
        List<AppUser> appUserListExists = this.appUserService.findAllAppUser();
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
        List<AppUser> appUserList = this.appUserService.findAllAppUser();
        return new ResponseEntity<>(appUserList, HttpStatus.OK);
    }

    @PutMapping("/edit/{ticket}/{passengerEdit}/{appUserID}")
    public ResponseEntity<Ticket> editTicket(@PathVariable Ticket ticket,
                                             @PathVariable String passengerEdit,
                                             @PathVariable Long appUserID) {
        ticket.setPassengerName(passengerEdit);
        List<AppUser> appUserList = this.appUserService.findAllAppUser();
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
        flightInformationDeparture =
                this.flightInformationService.findFlightInformationByID(idFlightInformationDeparture);

        // Create Booking
        Booking bookingCreate = createBooking(ticketDTO);

        // Create Ticket Departure
        createTicketDeparture(ticketDTO, passengerList, flightInformationDeparture,
                bookingCreate, ticketDTO.getPriceDeparture());

        // Create Ticket Arrival
        createTicketArrival(idFlightInformationArrival, ticketDTO, passengerList, bookingCreate);

        // Send Email for Customer
        sendEmail(ticketDTO, flightInformationDeparture);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Booking createBooking(@RequestBody TicketDTO ticketDTO) {
        Booking booking = new Booking();
        booking.setBookingCode(ticketDTO.getBooking());
        booking.setAppUser(this.appUserService.findAppUserByEmail(ticketDTO.getAppUser()));
        this.bookingService.saveBooking(booking);
        return this.bookingService.findBookingByBookingCode(ticketDTO.getBooking());
    }

    private void createTicketDeparture(@RequestBody TicketDTO ticketDTO, String[] passengerList,
                                       FlightInformation flightInformationDeparture, Booking bookingCreate,
                                       Double priceDeparture) {
        for (String passengerName : passengerList) {
            Ticket ticketDeparture = new Ticket();
            ticketDeparture.setFlightInformation(flightInformationDeparture);
            ticketDeparture.setPriceDeparture(priceDeparture / passengerList.length);
            setPropertiesOfTicket(ticketDTO, bookingCreate, passengerName, ticketDeparture);
        }
    }

    private void createTicketArrival(@PathVariable Long idFlightInformationArrival,
                                     @RequestBody TicketDTO ticketDTO, String[] passengerList,
                                     Booking bookingCreate) {
        if (!idFlightInformationArrival.equals(0L)) {

            // Find flightInformationArrival
            FlightInformation flightInformationArrival;
            flightInformationArrival =
                    this.flightInformationService.findFlightInformationByID(idFlightInformationArrival);

            for (String passengerName : passengerList) {
                Ticket ticketArrival = new Ticket();
                ticketArrival.setFlightInformation(flightInformationArrival);
                ticketArrival.setPriceDeparture(ticketDTO.getPriceArrival() / passengerList.length);
                setPropertiesOfTicket(ticketDTO, bookingCreate, passengerName, ticketArrival);
            }
        }
    }

    private void setPropertiesOfTicket(@RequestBody TicketDTO ticketDTO, Booking bookingCreate,
                                       String passengerName, Ticket ticketDeparture) {
        ticketDeparture.setPassengerName(passengerName);
        ticketDeparture.setStatusCheckin(false);
        String ticketCode = UUID.randomUUID().toString();
        ticketDeparture.setTicketCode(ticketCode);
        ticketDeparture.setBooking(bookingCreate);
        ticketDeparture.setAppUser(this.appUserService.findAppUserByEmail(ticketDTO.getAppUser()));
        ticketDeparture.setEmployee(this.employeeService.findEmployeeByID(ticketDTO.getEmployee()));
        ticketDeparture.setInvoice(this.invoiceService.findInvoiceByID(1L));
        ticketDeparture.setStatusPayment(this.statusPaymentService.findStatusPaymentByID(1L));
        this.ticketService.saveTicket(ticketDeparture);
    }

    private void sendEmail(@RequestBody TicketDTO ticketDTO, FlightInformation flightInformationDeparture) {
        SimpleMailMessage sendEmailForCustomer = new SimpleMailMessage();
        sendEmailForCustomer.setFrom("C06AirLine");
        sendEmailForCustomer.setTo(ticketDTO.getAppUser());
        sendEmailForCustomer.setSubject("C06AirLine cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! " +
                "Yêu cầu đặt vé của quý khách đã được thực hiện thành công.");
        sendEmailForCustomer.setText("Sau đây là thông tin của vé: ");
        sendEmailForCustomer.setText("Mã đặt chỗ: " + ticketDTO.getBooking()
                + "\nDanh sách hành khách: " + ticketDTO.getPassengerName()
                + "\nHãng bay: " + flightInformationDeparture.getAirline()
                + "\nNgày đi: " + flightInformationDeparture.getDepartureDate()
                + "\nGiờ khởi hành : " + flightInformationDeparture.getDepartureTime()
                + "\nQuý khách vui lòng đến sân bay trước 2 tiếng để làm thủ tục. "
                + "\nC06AirLine chúc quý khách thượng lộ bình an!");
        emailService.sendEmail(sendEmailForCustomer);
    }

    @GetMapping("/list-pending")
    public ResponseEntity<List<Ticket>> getListPendingTicket() {
        List<Ticket> ticketList = this.ticketService.findAllByStatusPaymentName(PENDING);
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }
}
