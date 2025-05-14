//package com.abby.hms.Repository;
//
//public class MedicalReportRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {
    // Custom queries can go here
}

