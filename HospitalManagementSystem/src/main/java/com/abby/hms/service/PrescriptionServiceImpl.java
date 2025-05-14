package com.abby.hms.service;

import com.abby.hms.model.Prescription;
import com.abby.hms.repository.PrescriptionRepository;
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
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElse(null);
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    @Override
    public Prescription updatePrescription(Long id, Prescription prescriptionDetails) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);

        if (prescription.isPresent()) {
            Prescription existingPrescription = prescription.get();
            existingPrescription.setMedication(prescriptionDetails.getMedication());
            existingPrescription.setDosage(prescriptionDetails.getDosage());
            // Add more fields as necessary

            return prescriptionRepository.save(existingPrescription);
        } else {
            return null;
        }
    }
}
