package comsprint1_ticket_agency_backend.service.ticket.impl;

import comsprint1_ticket_agency_backend.entity.Ticket;
import comsprint1_ticket_agency_backend.repository.TicketRepository;
import comsprint1_ticket_agency_backend.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void save(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public void edit(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        this.ticketRepository.deleteById(id);
    }

    @Override
    public Ticket findByID(Long id) {
        return this.ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findAll() {
        return this.ticketRepository.findAll();
    }
}
