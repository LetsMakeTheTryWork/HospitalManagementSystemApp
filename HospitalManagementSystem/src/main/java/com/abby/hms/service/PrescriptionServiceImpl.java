package com.abby.hms.service;

import com.abby.hms.model.Prescription;
import com.abby.hms.repository.PrescriptionRepository;
import com.abby.hms.exception.PrescriptionNotFoundException;  // Add the missing import here
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription savePrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Prescription cannot be null");
        }
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found with id: " + id));
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public void deletePrescription(Long id) {
        if (!prescriptionRepository.existsById(id)) {
            throw new PrescriptionNotFoundException("Prescription not found with id: " + id);
        }
        prescriptionRepository.deleteById(id);
    }

    @Override
    public Prescription updatePrescription(Long id, Prescription prescriptionDetails) {
        if (prescriptionDetails == null) {
            throw new IllegalArgumentException("Prescription details cannot be null");
        }

        Optional<Prescription> prescription = prescriptionRepository.findById(id);

        if (prescription.isPresent()) {
            Prescription existingPrescription = prescription.get();
            existingPrescription.setMedicine(prescriptionDetails.getMedicine());  // FIXED HERE
            existingPrescription.setDosage(prescriptionDetails.getDosage());
            // Add more fields as necessary

            return prescriptionRepository.save(existingPrescription);
        } else {
            throw new PrescriptionNotFoundException("Prescription not found for id: " + id);
        }
    }
}
