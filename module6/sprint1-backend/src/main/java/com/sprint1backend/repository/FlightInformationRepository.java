package com.sprint1backend.repository;

import com.sprint1backend.entity.FlightInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInformationRepository extends JpaRepository<FlightInformation, Long> {
}
