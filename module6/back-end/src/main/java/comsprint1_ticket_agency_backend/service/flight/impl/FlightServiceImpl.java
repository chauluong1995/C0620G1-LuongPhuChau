package comsprint1_ticket_agency_backend.service.flight.impl;

import comsprint1_ticket_agency_backend.entity.FlightInformation;
import comsprint1_ticket_agency_backend.repository.FlightRepository;
import comsprint1_ticket_agency_backend.service.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightInformation findByID(Long id) {
        return this.flightRepository.findById(id).orElse(null);
    }

    @Override
    public List<FlightInformation> findAll() {
        return this.flightRepository.findAll();
    }
}
