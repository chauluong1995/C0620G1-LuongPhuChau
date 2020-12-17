package com.sprint1backend.service.ticket;

import java.util.List;

import com.sprint1backend.entity.*;

public interface TicketService {
    void saveTicket(Ticket ticket);

    void editTicket(Ticket ticket);

    void deleteTicket(Long id);

    Ticket findTicketByID(Long id);

    List<Ticket> findAllTicket();

    List<Ticket> findAllByStatusPaymentName(String statusPaymentName);
}
