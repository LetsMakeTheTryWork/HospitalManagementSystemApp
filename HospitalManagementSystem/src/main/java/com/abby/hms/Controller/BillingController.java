//package com.abby.hms;
//
//public class BillingController {
//}

package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
@CrossOrigin("*")
public class BillingController {

    @GetMapping
    public String getAllBilling() {
        return "List of all billing records";
    }
}

