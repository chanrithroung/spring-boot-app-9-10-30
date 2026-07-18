package com.firstapp.firstapp.controller;

import com.firstapp.firstapp.entity.Class;
import com.firstapp.firstapp.entity.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    Teacher teacher = new Teacher(
            "TC-001",
            "HOUT MENGTEK",
            "CPP",
            List.of(
                    new Class("A01", "A01", "32T"),
                    new Class("A01", "A01", "32T"),
                    new Class("A01", "A01", "32T")

            )
    );
    @GetMapping
    Teacher getTeacher() {
        return teacher;
    }
}
