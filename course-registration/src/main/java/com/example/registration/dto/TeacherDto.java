package com.example.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<LessonDto> lessons;
//    private Set<CourseRegistrationDto> registrations;//подозреваю, что учителю не надо знать о регистрациях
    private boolean isClosedForNewStudents;//новое поле

}
