//package com.abby.hms.Repository;
//
//public class PrescriptionRepository {
//}


package com.abby.hms.repository;

import com.abby.hms.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    // Custom queries can go here
}
