//package com.abby.hms.Repository;
//
//public class BillingRepository {
//}

package com.abby.hms.repository;

import com.abby.hms.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    // Custom queries can go here
}

