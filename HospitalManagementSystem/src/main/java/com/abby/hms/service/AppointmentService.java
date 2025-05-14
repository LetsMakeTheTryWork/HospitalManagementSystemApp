package com.abby.hms.service;

import com.abby.hms.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    void deleteAppointment(Long id);
    Appointment updateAppointment(Long id, Appointment appointmentDetails);
}
