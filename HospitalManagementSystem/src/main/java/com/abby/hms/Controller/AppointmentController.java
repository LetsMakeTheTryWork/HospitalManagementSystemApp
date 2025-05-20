//package com.abby.hms;
//
//public class AppointmentController {
//}

package com.abby.hms.Controller;
import jakarta.persistence.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin("*")
public class AppointmentController {

    @GetMapping
    public String getAllAppointments() {
        return "List of all appointments";
    }
}

