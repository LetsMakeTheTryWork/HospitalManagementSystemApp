//package com.abby.hms.Repository;
//
//public class StaffRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    // Custom queries can go here
}

