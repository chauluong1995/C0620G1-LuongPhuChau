package com.sprint1backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.sprint1backend.entity.FlightInformation;
import com.sprint1backend.service.flight_information.FlightInformationService;

@RestController
@RequestMapping("/flight-information")
@CrossOrigin
public class FlightInformationRestController {
    @Autowired
    private FlightInformationService flightInformationService;

    @GetMapping("/list")
    public ResponseEntity<List<FlightInformation>> getListFlightInformation() {
        List<FlightInformation> flightInformationList = this.flightInformationService.findAllFlightInformation();
        return new ResponseEntity<>(flightInformationList, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<FlightInformation> getFlightInformationByID(@PathVariable Long id) {
        FlightInformation flightInformation = this.flightInformationService.findFlightInformationByID(id);
        return new ResponseEntity<>(flightInformation, HttpStatus.OK);
    }
}
