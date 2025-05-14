//package com.abby.hms.Repository;
//
//public class DoctorRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // You can add custom query methods here if needed
}
