//package com.abby.hms.Repository;
//
//public class DepartmentRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom queries can go here
}

