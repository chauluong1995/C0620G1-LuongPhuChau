package com.sprint1backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "flight", columnDefinition = "VARCHAR(40)")
    private String flight;

    @Column(name = "airline", columnDefinition = "VARCHAR(40)")
    private String airline;

    @Column(name = "flight_number", columnDefinition = "VARCHAR(40)")
    private String flightNumber;

    @Column(name = "departure_date", columnDefinition = "DATE")
    private LocalDate departureDate;

    @Column(name = "departure_place", columnDefinition = "VARCHAR(40)")
    private String departurePlace;

    @Column(name = "departure_time", columnDefinition = "TIME")
    private LocalTime departureTime;

    @Column(name = "arrival_date", columnDefinition = "DATE")
    private LocalDate arrivalDate;

    @Column(name = "arrival_place", columnDefinition = "VARCHAR(40)")
    private String arrivalPlace;

    @Column(name = "arrival_time", columnDefinition = "TIME")
    private LocalTime arrivalTime;

    @Column(name = "information", columnDefinition = "VARCHAR(40)")
    private String information;

    @Column(name = "price", columnDefinition = "DOUBLE")
    private Double price;







}
