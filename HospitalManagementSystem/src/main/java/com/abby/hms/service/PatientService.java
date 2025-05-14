package com.abby.hms.service;

import com.abby.hms.model.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void deletePatient(Long id);
    Patient updatePatient(Long id, Patient patientDetails);
}
