package com.sprint1backend.service.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1backend.entity.Invoice;
import com.sprint1backend.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice findInvoiceByID(Long id) {
        return this.invoiceRepository.findById(id).orElse(null);
    }
}
