package com.sprint1backend.controller.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.sprint1backend.entity.*;
import com.sprint1backend.model.TicketDTO;
import com.sprint1backend.entity.StatusPayment;
import com.sprint1backend.entity.Ticket;
import com.sprint1backend.model.MessageDTO;
import com.sprint1backend.model.TicketSearchDTO;
import com.sprint1backend.model.TicketStatusPaymentDTO;
import com.sprint1backend.service.status_payment.StatusPaymentService;
import com.sprint1backend.service.ticket.TicketService;
import com.sprint1backend.service.flight_information.FlightInformationService;
import com.sprint1backend.service.user.AppUserService;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketRestController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightInformationService flightInformationService;

    @Autowired
    private StatusPaymentService statusPaymentService;

    @Autowired
    private AppUserService appUserService;

    /*
     * get all ticket in database
     * @param Nothing
     * @return ResponseEntity<List<Ticket>>
     * */
    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> getListTicket() {
        List<Ticket> ticketList = this.ticketService.findAllTicket();
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    /* *
     * Chau start
     * */

    /*
     * get flight information by id
     * @param idFlightInformation
     * @return ResponseEntity<FlightInformation>
     * */
    @GetMapping("/find-flight-information-by-id/{id}")
    public ResponseEntity<FlightInformation> getFlightInformationByID(@PathVariable Long id) {
        FlightInformation flightInformation = this.flightInformationService.findFlightInformationByID(id);
        return new ResponseEntity<>(flightInformation, HttpStatus.OK);
    }

    /*
     * get list app user by email
     * @param email
     * @return ResponseEntity<List<AppUser>>
     * */
    @GetMapping("/app-user/{emailInput}")
    public ResponseEntity<List<AppUser>> searchAppUserByEmail(@PathVariable String emailInput) {
        List<AppUser> appUserList = this.appUserService.testEmailOfAppUser(emailInput);
        return new ResponseEntity<>(appUserList, HttpStatus.OK);
    }

    /*
     * get ticket by id
     * @param idTicket
     * @return ResponseEntity<Ticket>
     * */
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Ticket> getTicketByID(@PathVariable Long id) {
        Ticket ticket = this.ticketService.findTicketByID(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    /*
     * delete ticket by id
     * @param idTicket
     * @return ResponseEntity<MessageDTO>
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteTicketByID(@PathVariable Long id) {
        String message = this.ticketService.deleteTicket(id);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    /*
     * edit ticket
     * @param ticketOld, passengerNameEdit, emailEdit
     * @return ResponseEntity<MessageDTO>
     * */
    @PutMapping("/edit/{passengerNameEdit}/{emailEdit}")
    public ResponseEntity<MessageDTO> editTicket(@PathVariable String passengerNameEdit,
                                                 @PathVariable String emailEdit,
                                                 @RequestBody TicketDTO ticketDTO) {
        String message = this.ticketService.editTicket(ticketDTO, passengerNameEdit, emailEdit);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    /*
     * save ticket
     * @param idFlightDeparture, idFlightArrival, ticketDTO
     * @return ResponseEntity<MessageDTO>
     * */
    @PostMapping("/save/{idFlightDeparture}/{idFlightArrival}")
    public ResponseEntity<MessageDTO> saveTicket(@PathVariable Long idFlightDeparture,
                                                 @PathVariable Long idFlightArrival,
                                                 @RequestBody TicketDTO ticketDTO) {
        String message = this.ticketService.saveTicket(ticketDTO, idFlightDeparture, idFlightArrival);
        return new ResponseEntity<>(new MessageDTO(message), HttpStatus.OK);
    }

    /* *
     * Chau end
     * */



    /*
     * Đăng start
     * */

    /*
     * get List Ticket by Status Payment
     * @param statusPaymentName
     * @return ResponseEntity<List<Ticket>>
     * @throw
     * */
    @GetMapping("/list/{statusPaymentName}")
    public ResponseEntity<List<Ticket>> findAllTicketByStatusPayment(@PathVariable String statusPaymentName) {
        List<Ticket> ticketList = this.ticketService.findAllByStatusPaymentName(statusPaymentName);
        if (ticketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    //
    /*
     * get List Ticket by Status Payment and another filter (Booking Code or Phone Number)
     * @param statusPaymentName, searchBy, searchValue
     * @return ResponseEntity<List<Ticket>>
     * @throw
     * */
    @GetMapping("/search")
    public ResponseEntity<List<Ticket>> searchTicket(
            @RequestParam String statusPaymentName,
            @RequestParam String searchBy,
            @RequestParam String searchValue
    ) {
        List<Ticket> tempTicketList = this.ticketService.findAllByStatusPaymentName(statusPaymentName);
        List<Ticket> ticketList = new ArrayList<>();
        switch (searchBy) {
            case "bookingCode":
                for (Ticket ticket : tempTicketList) {
                    if (ticket.getBooking().getBookingCode().equals(searchValue)) {
                        ticketList.add(ticket);
                    }
                }
                if (ticketList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                break;
            case "phoneNumber":
                for (Ticket ticket : tempTicketList) {
                    if (ticket.getBooking().getAppUser().getPhoneNumber().equals(searchValue)) {
                        ticketList.add(ticket);
                    }
                }
                if (ticketList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                break;
            default:
                return new ResponseEntity<>(ticketList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/search2")
    public ResponseEntity<List<Ticket>> search2Ticket(
            @RequestBody TicketSearchDTO ticketSearchDTO
    ) {
        System.err.println("ticketSearchDTO");
        System.err.println(ticketSearchDTO);
        List<Ticket> tempTicketList = this.ticketService.findAllByStatusPaymentName(ticketSearchDTO.getStatusPaymentName());
        List<Ticket> ticketList = new ArrayList<>();
        switch (ticketSearchDTO.getSearchBy()) {
            case "bookingCode":
                for (Ticket ticket : tempTicketList) {
                    if (ticket.getBooking().getBookingCode().equals(ticketSearchDTO.getSearchValue())) {
                        ticketList.add(ticket);
                    }
                }
                if (ticketList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                break;
            case "phoneNumber":
                for (Ticket ticket : tempTicketList) {
                    if (ticket.getBooking().getAppUser().getPhoneNumber().equals(ticketSearchDTO.getSearchValue())) {
                        ticketList.add(ticket);
                    }
                }
                if (ticketList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                break;
            default:
                return new ResponseEntity<>(ticketList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }


    /*
     * Edit Status Payment of Ticket
     * @param id, ticketStatusPaymentDTO
     * @return ResponseEntity<Ticket>
     * @throw
     *
     * */
    @PutMapping("/set-status-payment/{id}")
    public ResponseEntity<Ticket> cancelTicket(@PathVariable Long id,
                                               @RequestBody TicketStatusPaymentDTO ticketStatusPaymentDTO) {
        Ticket ticket = this.ticketService.findTicketByID(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        StatusPayment statusPayment = this.statusPaymentService.findByName(
                ticketStatusPaymentDTO.getStatusPaymentName());
        if (statusPayment == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        ticket.setStatusPayment(statusPayment);
        this.ticketService.saveTicketAfterSetStatusPayment(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
    /*
     * Đăng end
     * */
}
