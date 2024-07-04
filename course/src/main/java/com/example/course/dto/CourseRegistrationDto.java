package com.example.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistrationDto {
    private Long id;
    private Long courseId;
    private StudentDto student;
    private TeacherDto teacher;
    private LocalDateTime registeredAt;//мы его до этого не переносили
}
