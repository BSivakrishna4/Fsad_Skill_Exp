package com.klu;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    Map<Integer, Student> db = new HashMap<>();

    @PostMapping
    public String add(@RequestBody Student s) {
        db.put(s.id, s);
        return "Student Added";
    }

    @GetMapping
    public Collection<Student> getAll() {
        return db.values();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable int id) {
        return db.get(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Student s) {
        db.put(id, s);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        db.remove(id);
        return "Deleted";
    }
}