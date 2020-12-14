package com.sprint1backend.service.flightInformation;

import com.sprint1backend.entity.FlightInformation;

import java.util.List;

public interface FlightInformationService {
    FlightInformation findFlightInformationByID(Long id);

    List<FlightInformation> findAllFlightInformation();
}
