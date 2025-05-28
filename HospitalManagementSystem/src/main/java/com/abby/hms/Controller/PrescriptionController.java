//package com.abby.hms;
//
//public class PrescriptionController {
//}


package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin("*")
public class PrescriptionController {

    @GetMapping
    public String getAllPrescriptions() {

        return "List of all prescriptions";
    }
}
