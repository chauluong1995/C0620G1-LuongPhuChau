package comsprint1_ticket_agency_backend.repository;

import comsprint1_ticket_agency_backend.entity.FlightInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightInformation, Long> {
}
