package com.sprint1backend.model;

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

    public TicketDTO() {
    }

    public Long getAdults() {
        return adults;
    }

    public void setAdults(Long adults) {
        this.adults = adults;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public Long getBabies() {
        return babies;
    }

    public void setBabies(Long babies) {
        this.babies = babies;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Double getPriceArrival() {
        return priceArrival;
    }

    public void setPriceArrival(Double priceArrival) {
        this.priceArrival = priceArrival;
    }

    public Double getPriceDeparture() {
        return priceDeparture;
    }

    public void setPriceDeparture(Double priceDeparture) {
        this.priceDeparture = priceDeparture;
    }

    public String getStatusCheckin() {
        return statusCheckin;
    }

    public void setStatusCheckin(String statusCheckin) {
        this.statusCheckin = statusCheckin;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
}
