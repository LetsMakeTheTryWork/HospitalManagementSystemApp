//package com.abby.hms.Repository;
//
//public class AppointmentRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Custom queries can go here
}

