package com.sprint1backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1backend.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByBookingCode(String bookingCode);
}
