package com.abby.hms.service;

import com.abby.hms.model.Billing;
import com.abby.hms.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public Billing saveBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    @Override
    public Billing getBillingById(Long id) {
        Optional<Billing> billing = billingRepository.findById(id);
        return billing.orElse(null);
    }

    @Override
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    @Override
    public void deleteBilling(Long id) {
        billingRepository.deleteById(id);
    }

    @Override
    public Billing updateBilling(Long id, Billing billingDetails) {
        Optional<Billing> billing = billingRepository.findById(id);

        if (billing.isPresent()) {
            Billing existingBilling = billing.get();
            existingBilling.setAmount(billingDetails.getAmount());
            existingBilling.setPatient(billingDetails.getPatient());
            // Add more fields as necessary

            return billingRepository.save(existingBilling);
        } else {
            return null;
        }
    }
}
