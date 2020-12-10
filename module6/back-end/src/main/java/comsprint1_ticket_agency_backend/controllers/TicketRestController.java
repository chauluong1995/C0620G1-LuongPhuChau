package comsprint1_ticket_agency_backend.controllers;

import comsprint1_ticket_agency_backend.entity.Ticket;
import comsprint1_ticket_agency_backend.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketRestController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> getListCustomer() {
        List<Ticket> ticketList = this.ticketService.findAll();
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity<Ticket> getTicketByID(@PathVariable Long id) {
        Ticket ticket = this.ticketService.findByID(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ticket> deleteTicketByID(@PathVariable Long id) {
        this.ticketService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
