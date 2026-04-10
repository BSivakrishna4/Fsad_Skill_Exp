package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // HARD CODED USERS (for experiment)
        if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
            return jwtUtil.generateToken(user.getUsername(), "ADMIN");
        }

        if (user.getUsername().equals("emp") && user.getPassword().equals("123")) {
            return jwtUtil.generateToken(user.getUsername(), "EMPLOYEE");
        }

        return "Invalid credentials";
    }
}