package com.example.registration.service;

import com.example.registration.dto.CourseRegistrationDto;

import java.util.Set;

public interface CourseRegistrationService {
    Set<CourseRegistrationDto> getRegistrationsForCourse(Long courseId);

}
