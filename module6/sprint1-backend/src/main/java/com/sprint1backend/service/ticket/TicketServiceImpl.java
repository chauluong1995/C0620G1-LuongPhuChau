package com.sprint1backend.service.ticket;

import com.sprint1backend.entity.AppUser;
import com.sprint1backend.entity.FlightInformation;
import com.sprint1backend.entity.Ticket;
import com.sprint1backend.repository.AppUserRepository;
import com.sprint1backend.repository.FlightInformationRepository;
import com.sprint1backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightInformationRepository flightInformationRepository;

    @Autowired
    private AppUserRepository appUserRepository;

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
    public FlightInformation findFlightInformationByID(Long id) {
        return this.flightInformationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findAllTicket() {
        return this.ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findAllByStatusPaymentName(String statusPaymentName) {
        return this.ticketRepository.findAllByStatusPayment_Name(statusPaymentName);
    }

    @Override
    public List<AppUser> findAllAppUser() {
        return this.appUserRepository.findAll();
    }
}
