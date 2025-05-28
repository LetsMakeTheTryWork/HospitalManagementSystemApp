//package com.abby.hms;
//
//public class PatientController {
//}

package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("*")
public class PatientController {


    @GetMapping
    public String getAllPatients() {
        return "List of all patients";
    }
}

