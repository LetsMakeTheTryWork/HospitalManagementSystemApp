//package com.abby.hms;
//
//public class StaffController {
//}


package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin("*")
public class StaffController {

    @GetMapping
    public String getAllStaff() {
        return "List of all staff";
    }
}
