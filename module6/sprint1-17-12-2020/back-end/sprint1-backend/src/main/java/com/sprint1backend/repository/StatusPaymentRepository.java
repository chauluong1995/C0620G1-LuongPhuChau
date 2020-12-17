package com.sprint1backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1backend.entity.StatusPayment;

@Repository
public interface StatusPaymentRepository extends JpaRepository<StatusPayment, Long> {
}
