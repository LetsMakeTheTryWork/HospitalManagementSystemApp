package com.abby.hms.service;

import com.abby.hms.model.Patient;
import com.abby.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Save or update a patient
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get a patient by their ID
    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);  // Returns null if no patient found
    }

    // Get all patients
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Delete a patient by their ID
    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Update patient details
    @Override
    public Patient updatePatient(Long id, Patient patientDetails) {
        Optional<Patient> patient = patientRepository.findById(id);

        if (patient.isPresent()) {
            Patient existingPatient = patient.get();
            existingPatient.setName(patientDetails.getName());
            existingPatient.setAddress(patientDetails.getAddress());
            existingPatient.setPhone(patientDetails.getPhone());
            // Add more fields as necessary

            return patientRepository.save(existingPatient);
        } else {
            return null;  // Patient not found
        }
    }
}
