package com.abby.hms.service;

import com.abby.hms.model.Billing;

import java.util.List;

public interface BillingService {
    Billing saveBilling(Billing billing);
    Billing getBillingById(Long id);
    List<Billing> getAllBillings();
    void deleteBilling(Long id);
    Billing updateBilling(Long id, Billing billingDetails);
}
