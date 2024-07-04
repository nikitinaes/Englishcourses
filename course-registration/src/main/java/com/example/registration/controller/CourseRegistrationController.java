package com.example.registration.controller;

import com.example.registration.dto.CourseRegistrationDto;
import com.example.registration.service.CourseRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@AllArgsConstructor
@RestController
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    @GetMapping("/registrations/{courseId}")
    public Set<CourseRegistrationDto> getRegistrationsForCourse(@PathVariable Long courseId) {
        return courseRegistrationService.getRegistrationsForCourse(courseId);
    }
}
