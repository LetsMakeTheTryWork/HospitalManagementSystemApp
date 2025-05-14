//package com.abby.hms.Repository;
//
//public class ScheduleSlotRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.ScheduleSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleSlotRepository extends JpaRepository<ScheduleSlot, Long> {
    // Custom queries can go here
}

