package com.sprint1backend.service.flight_information;

import java.util.List;

import com.sprint1backend.entity.FlightInformation;

public interface FlightInformationService {
    FlightInformation findFlightInformationByID(Long id);

    List<FlightInformation> findAllFlightInformation();
}
