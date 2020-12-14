package com.sprint1backend.service.ticket;

import com.sprint1backend.entity.AppUser;
import com.sprint1backend.entity.FlightInformation;
import com.sprint1backend.entity.Ticket;

import java.util.List;

public interface TicketService {
    void saveTicket(Ticket ticket);

    void editTicket(Ticket ticket);

    void deleteTicket(Long id);

    Ticket findTicketByID(Long id);

    FlightInformation findFlightInformationByID(Long id);

    List<Ticket> findAllTicket();

    List<Ticket> findAllByStatusPaymentName(String statusPaymentName);

    List<AppUser> findAllAppUser();
}
