package com.sprint1backend.service.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sprint1backend.entity.*;
import com.sprint1backend.repository.*;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void saveTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public void editTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        this.ticketRepository.deleteById(id);
    }

    @Override
    public Ticket findTicketByID(Long id) {
        return this.ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findAllTicket() {
        return this.ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findAllByStatusPaymentName(String statusPaymentName) {
        return this.ticketRepository.findAllByStatusPayment_Name(statusPaymentName);
    }
}
