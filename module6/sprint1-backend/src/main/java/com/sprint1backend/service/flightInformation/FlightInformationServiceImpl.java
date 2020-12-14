package com.sprint1backend.service.flightInformation;

import com.sprint1backend.entity.FlightInformation;
import com.sprint1backend.repository.FlightInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInformationServiceImpl implements FlightInformationService {
    @Autowired
    private FlightInformationRepository flightInformationRepository;

    @Override
    public FlightInformation findFlightInformationByID(Long id) {
        return this.flightInformationRepository.findById(id).orElse(null);
    }

    @Override
    public List<FlightInformation> findAllFlightInformation() {
        return this.flightInformationRepository.findAll();
    }
}
