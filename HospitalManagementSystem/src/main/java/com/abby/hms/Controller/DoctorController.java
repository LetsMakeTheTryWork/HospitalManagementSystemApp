//package com.abby.hms;
//
//public class DoctorController {
//}
package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin("*")
public class DoctorController {

    @GetMapping
    public String getAllDoctors() {
        return "List of all doctors";
    }
}
