package com.sprint1backend.service.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import com.sprint1backend.entity.*;
import com.sprint1backend.repository.*;
import com.sprint1backend.model.TicketDTO;
import com.sprint1backend.service.booking.BookingService;
import com.sprint1backend.service.email.EmailService;
import com.sprint1backend.service.employee.EmployeeService;
import com.sprint1backend.service.invoice.InvoiceService;
import com.sprint1backend.service.flight_information.FlightInformationService;
import com.sprint1backend.service.status_payment.StatusPaymentService;
import com.sprint1backend.service.user.AppUserService;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private FlightInformationService flightInformationService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private StatusPaymentService statusPaymentService;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    /* *
     * Chau start
     * */

    /*
     * get ticket by id
     * @param idTicket
     * @return Ticket
     * */
    @Override
    public Ticket findTicketByID(Long id) {
        return this.ticketRepository.findById(id).orElse(null);
    }

    /*
     * delete ticket by id
     * @param idTicket
     * @return String
     * */
    @Override
    public String deleteTicket(Long id) {
        try {
            this.ticketRepository.deleteById(id);
        } catch (RuntimeException runtime) {
            return "Failed";
        }
        return "Succeed";
    }

    /*
     * edit ticket by id
     * @param idTicket, passengerNameEdit, emailEdit
     * @return String
     * */
    @Override
    public String editTicket(Ticket ticket, String passengerNameEdit, String emailEdit) {
        try {
            ticket.setPassengerName(passengerNameEdit);
            ticket.setAppUser(this.appUserRepository.findByEmail(emailEdit));
            this.ticketRepository.save(ticket);
        } catch (RuntimeException runtime) {
            return "Failed";
        }
        return "Succeed";
    }

    /*
     * save ticket
     * @param ticketDTO, idFlightDeparture, idFlightArrival
     * @return String
     * */
    @Override
    public String saveTicket(TicketDTO ticketDTO, Long idFlightDeparture, Long idFlightArrival) {
        if (ticketDTO != null && idFlightDeparture != 0L) {
            // Customer list analysis
            String[] passengerList = getPassengerList(ticketDTO);

            // Find flightInformationDeparture
            FlightInformation flightInformationDeparture = getFlightInformation(idFlightDeparture);

            // Create Booking
            Booking bookingCreate = createNewBooking(ticketDTO);

            // Create Ticket Departure
            String messageSaveDeparture = createTicket(ticketDTO, passengerList, flightInformationDeparture,
                    bookingCreate, ticketDTO.getPriceDeparture());

            // Create Ticket Arrival
            if (!idFlightArrival.equals(0L)) {
                // Find flightInformationArrival
                FlightInformation flightInformationArrival = getFlightInformation(idFlightArrival);
                 createTicket(ticketDTO, passengerList, flightInformationArrival,
                        bookingCreate, ticketDTO.getPriceArrival());
            }

            // Send Email for Customer
            if (messageSaveDeparture.equals("Succeed")) {
                String messageEmail = sendEmailForCustomer(ticketDTO, flightInformationDeparture);
                if (messageEmail.equals("Succeed")) {
                    return "Save ticket and send mail succeed";
                } else {
                    return "Send mail failed";
                }
            } else {
                return "Save ticket failed";
            }
        } else {
            return "No data";
        }
    }

    private String[] getPassengerList(TicketDTO ticketDTO) {
        String passengers = ticketDTO.getPassengerName();
        String[] passengerList;
        passengerList = passengers.split(",");
        return passengerList;
    }

    private FlightInformation getFlightInformation(Long idFlightDeparture) {
        FlightInformation flightInformationDeparture;
        flightInformationDeparture =
                this.flightInformationService.findFlightInformationByID(idFlightDeparture);
        return flightInformationDeparture;
    }

    private Booking createNewBooking(TicketDTO ticketDTO) {
        Booking booking = new Booking();
        booking.setBookingCode(ticketDTO.getBooking());
        booking.setAppUser(this.appUserService.findAppUserByEmail(ticketDTO.getAppUser()));
        this.bookingService.saveBooking(booking);
        return this.bookingService.findBookingByBookingCode(ticketDTO.getBooking());
    }

    private String createTicket(TicketDTO ticketDTO, String[] passengerList,
                                FlightInformation flightInformationDeparture,
                                Booking bookingCreate, Double price) {
        try {
            for (String passengerName : passengerList) {
                Ticket ticketDeparture = new Ticket();
                ticketDeparture.setFlightInformation(flightInformationDeparture);
                ticketDeparture.setPriceDeparture(price / passengerList.length);
                setPropertiesOfTicket(ticketDTO, bookingCreate, passengerName, ticketDeparture);
                this.ticketRepository.save(ticketDeparture);
            }
        } catch (RuntimeException runtime) {
            return "Failed";
        }
        return "Succeed";
    }

    private void setPropertiesOfTicket(TicketDTO ticketDTO, Booking bookingCreate,
                                       String passengerName, Ticket ticket) {
        ticket.setPassengerName(passengerName);
        ticket.setStatusCheckin(false);
        String ticketCode = UUID.randomUUID().toString();
        ticket.setTicketCode(ticketCode);
        ticket.setBooking(bookingCreate);
        ticket.setAppUser(this.appUserService.findAppUserByEmail(ticketDTO.getAppUser()));
        ticket.setEmployee(this.employeeService.findEmployeeById(ticketDTO.getEmployee()));
        ticket.setInvoice(this.invoiceService.findInvoiceByID(1L));
        ticket.setStatusPayment(this.statusPaymentService.findByName("Pending"));
    }

    private String sendEmailForCustomer(TicketDTO ticketDTO, FlightInformation flightInformationDeparture) {
        try {
            SimpleMailMessage sendEmailForCustomer = new SimpleMailMessage();
            sendEmailForCustomer.setFrom("C06AirLine");
            sendEmailForCustomer.setTo(ticketDTO.getAppUser());
            sendEmailForCustomer.setSubject("C06AirLine cảm ơn quý khách đã sử dụng dịch vụ của chúng tôi! " +
                    "Yêu cầu đặt vé của quý khách đã được thực hiện thành công.");
            sendEmailForCustomer.setText("Sau đây là thông tin của vé: ");
            sendEmailForCustomer.setText("Dear " + ticketDTO.getAppUser() + ","
                    + "\nMã đặt chỗ: " + ticketDTO.getBooking()
                    + "\nDanh sách hành khách: " + ticketDTO.getPassengerName()
                    + "\nHãng bay: " + flightInformationDeparture.getAirline()
                    + "\nNgày đi: " + flightInformationDeparture.getDepartureDate()
                    + "\nGiờ khởi hành : " + flightInformationDeparture.getDepartureTime()
                    + "\nQuý khách vui lòng đến sân bay trước 2 tiếng để làm thủ tục. "
                    + "\nC06AirLine chúc quý khách thượng lộ bình an!");
            emailService.sendEmail(sendEmailForCustomer);
        } catch (RuntimeException runtime) {
            return "Failed";
        }
        return "Succeed";
    }

    /* *
     * Chau end
     * */

    @Override
    public List<Ticket> findAllTicket() {
        return this.ticketRepository.findAll();
    }

    @Override
    public void saveTicketAfterSetStatusPayment(Ticket ticket) {
        this.ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAllByStatusPaymentName(String statusPaymentName) {
        return this.ticketRepository.findAllByStatusPayment_Name(statusPaymentName);
    }
}
