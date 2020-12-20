package com.sprint1backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1backend.entity.FlightInformation;

@Repository
public interface FlightInformationRepository extends JpaRepository<FlightInformation, Long> {
}
