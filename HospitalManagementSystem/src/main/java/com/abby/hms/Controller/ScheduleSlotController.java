//package com.abby.hms;
//
//public class ScheduleSlotController {
//}


package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule-slots")
@CrossOrigin("*")
public class ScheduleSlotController {

    @GetMapping
    public String getAllScheduleSlots() {
        return "List of all schedule slots";
    }
}
