package com.abby.hms.service;

import com.abby.hms.model.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription savePrescription(Prescription prescription);
    Prescription getPrescriptionById(Long id);
    List<Prescription> getAllPrescriptions();
    void deletePrescription(Long id);
    Prescription updatePrescription(Long id, Prescription prescriptionDetails);
}
