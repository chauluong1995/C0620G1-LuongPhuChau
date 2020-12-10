package comsprint1_ticket_agency_backend.service.ticket;

import comsprint1_ticket_agency_backend.entity.Ticket;

import java.util.List;

public interface TicketService {
    void save(Ticket ticket);

    void edit(Ticket ticket);

    void delete(Long id);

    Ticket findByID(Long id);

    List<Ticket> findAll();
}
