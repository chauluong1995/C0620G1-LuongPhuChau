package comsprint1_ticket_agency_backend.controllers;

import comsprint1_ticket_agency_backend.entity.FlightInformation;
import comsprint1_ticket_agency_backend.service.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin
public class FlightRestController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/list")
    public ResponseEntity<List<FlightInformation>> getListFlight() {
        List<FlightInformation> flightList = this.flightService.findAll();
        return new ResponseEntity<>(flightList, HttpStatus.OK);
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity<FlightInformation> getFlightByID(@PathVariable Long id) {
        FlightInformation flight = this.flightService.findByID(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}
