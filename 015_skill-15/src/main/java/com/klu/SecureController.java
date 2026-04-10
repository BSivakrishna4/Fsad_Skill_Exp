package com.klu;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecureController {

    @GetMapping("/admin/add")
    public String adminAdd() {
        return "Admin Add Success";
    }

    @GetMapping("/admin/delete")
    public String adminDelete() {
        return "Admin Delete Success";
    }

    @GetMapping("/employee/profile")
    public String employeeProfile() {
        return "Employee Profile Data";
    }
}