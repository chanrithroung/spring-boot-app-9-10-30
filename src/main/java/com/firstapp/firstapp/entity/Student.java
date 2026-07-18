package com.firstapp.firstapp.entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentId;
    private String studentName;
    private String studentGender;
}