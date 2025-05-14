//package com.abby.hms.Repository;
//
//public class PatientRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Custom queries can go here
}

