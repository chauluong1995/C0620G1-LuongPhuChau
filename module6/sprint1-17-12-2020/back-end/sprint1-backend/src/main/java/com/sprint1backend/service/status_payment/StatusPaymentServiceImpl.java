package com.sprint1backend.service.status_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1backend.entity.StatusPayment;
import com.sprint1backend.repository.StatusPaymentRepository;

@Service
public class StatusPaymentServiceImpl implements StatusPaymentService {
    @Autowired
    private StatusPaymentRepository statusPaymentRepository;

    @Override
    public StatusPayment findStatusPaymentByID(Long id) {
        return this.statusPaymentRepository.findById(id).orElse(null);
    }
}
