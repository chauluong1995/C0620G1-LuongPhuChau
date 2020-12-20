package com.sprint1backend.service.ticket;

import java.util.List;

import com.sprint1backend.entity.*;
import com.sprint1backend.model.TicketDTO;

public interface TicketService {
    String saveTicket(TicketDTO ticketDTO, Long idFlightDeparture, Long idFlightArrival);

    void saveTicketAfterSetStatusPayment(Ticket ticket);

    String editTicket(TicketDTO ticketDTO, String passengerNameEdit, String emailEdit);

    String deleteTicket(Long id);

    Ticket findTicketByID(Long id);

    List<Ticket> findAllTicket();

    List<Ticket> findAllByStatusPaymentName(String statusPaymentName);
}
