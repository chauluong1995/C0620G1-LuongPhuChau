package com.sprint1backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Long adults;
    private String appUser;
    private Long babies;
    private String booking;
    private Long employee;
    private String id;
    private String invoice;
    private String passengerName;
    private Double priceArrival;
    private Double priceDeparture;
    private String statusCheckin;
    private String statusPayment;
    private String ticketCode;
}
