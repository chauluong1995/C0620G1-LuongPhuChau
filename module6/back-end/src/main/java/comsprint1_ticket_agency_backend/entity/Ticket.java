package comsprint1_ticket_agency_backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketCode;
    private String bookingCode;

    @NotNull
    private Double priceDeparture;

    @NotNull
    private Double priceArrival;

    private Date bookingDate;
    private String statusCheckin;

    @ManyToOne
    @JoinColumn(name = "flight_code_id", referencedColumnName = "id")
    private FlightInformation flightInformation;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Double getPriceDeparture() {
        return priceDeparture;
    }

    public void setPriceDeparture(Double priceDeparture) {
        this.priceDeparture = priceDeparture;
    }

    public Double getPriceArrival() {
        return priceArrival;
    }

    public void setPriceArrival(Double priceArrival) {
        this.priceArrival = priceArrival;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatusCheckin() {
        return statusCheckin;
    }

    public void setStatusCheckin(String statusCheckin) {
        this.statusCheckin = statusCheckin;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }
}
