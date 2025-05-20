package com.abby.hms.service;

import com.abby.hms.model.Appointment;
import com.abby.hms.repository.AppointmentRepository;
import com.abby.hms.exception.AppointmentNotFoundException; // ✅ Import added

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + id));
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new AppointmentNotFoundException("Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
        if (appointmentDetails == null) {
            throw new IllegalArgumentException("Appointment details cannot be null");
        }

        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + id));

        existingAppointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        existingAppointment.setPatient(appointmentDetails.getPatient());
        // Add more fields as necessary

        return appointmentRepository.save(existingAppointment);
    }
}
