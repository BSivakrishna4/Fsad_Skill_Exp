package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    Map<String, String> db = new HashMap<>();

    @PostMapping("/register")
    public String register(@RequestBody Map<String,String> user) {
        db.put(user.get("username"), user.get("password"));
        return "Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> user) {
        if(db.containsKey(user.get("username")) &&
           db.get(user.get("username")).equals(user.get("password"))) {
            return "SUCCESS";
        }
        return "FAIL";
    }

    @GetMapping("/profile/{username}")
    public Map<String,String> profile(@PathVariable String username) {
        Map<String,String> res = new HashMap<>();
        res.put("username", username);
        return res;
    }
}