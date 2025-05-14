//package com.abby.hms;
//
//public class MedicalReportController {
//}

package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-reports")
@CrossOrigin("*")
public class MedicalReportController {

    @GetMapping
    public String getAllMedicalReports() {
        return "List of all medical reports";
    }
}

