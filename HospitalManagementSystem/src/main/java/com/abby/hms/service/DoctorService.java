package com.abby.hms.service;

import com.abby.hms.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    void deleteDoctor(Long id);
}
