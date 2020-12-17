package com.sprint1backend.service.invoice;

import com.sprint1backend.entity.Invoice;

public interface InvoiceService {
    Invoice findInvoiceByID(Long id);
}
