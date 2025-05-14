//package com.abby.hms;
//
//public class DepartmentController {
//}

package com.abby.hms.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {

    @GetMapping
    public String getAllDepartments() {
        return "List of all departments";
    }
}

