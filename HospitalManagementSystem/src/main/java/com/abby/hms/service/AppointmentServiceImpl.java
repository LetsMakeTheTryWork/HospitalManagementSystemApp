package com.abby.hms.service;

import com.abby.hms.model.Appointment;
import com.abby.hms.repository.AppointmentRepository;
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
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isPresent()) {
            Appointment existingAppointment = appointment.get();
            existingAppointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            existingAppointment.setPatient(appointmentDetails.getPatient());
            // Add more fields as necessary

            return appointmentRepository.save(existingAppointment);
        } else {
            return null;
        }
    }
}
