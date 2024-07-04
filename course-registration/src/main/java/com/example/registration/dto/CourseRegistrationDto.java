package com.example.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationDto {

    private Long id;
    private Long courseId;
    private StudentDto student;
    private TeacherDto teacher;
//    private Long teacherId;
    private LocalDateTime registeredAt;
}
