package comsprint1_ticket_agency_backend.service.flight;

import comsprint1_ticket_agency_backend.entity.FlightInformation;

import java.util.List;

public interface FlightService {
    FlightInformation findByID(Long id);

    List<FlightInformation> findAll();
}
