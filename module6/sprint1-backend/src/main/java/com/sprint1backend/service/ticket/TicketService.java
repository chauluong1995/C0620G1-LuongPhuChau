package com.sprint1backend.service.ticket;

import com.sprint1backend.entity.*;

import java.util.List;

public interface TicketService {
    void saveTicket(Ticket ticket);

    void saveBooking(Booking booking);

    void editTicket(Ticket ticket);

    void deleteTicket(Long id);

    Ticket findTicketByID(Long id);

    Booking findBookingByBookingCode(String bookingCode);

    FlightInformation findFlightInformationByID(Long id);

    List<Ticket> findAllTicket();

    List<Ticket> findAllByStatusPaymentName(String statusPaymentName);

    List<AppUser> findAllAppUser();

    List<Employee> findAllEmployee();
}
