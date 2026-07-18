package com.firstapp.firstapp.controller;
import com.firstapp.firstapp.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    Student student = new Student("STU0001", "Chanrith", "Male");
    @GetMapping
    Student getStudent() {
        return student;
    }

}
