package com.example.course.service;

import com.example.course.dto.CourseRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "course-registration-service", url = "http://localhost:8081")//будет обнаружен Eureka, чтоб этот к ней обращался
public interface CourseRegistrationClient {
    @GetMapping("/registrations/{courseId}")
    Set<CourseRegistrationDto> getRegistrationsForCourse(@PathVariable("courseId") Long courseId);
    //в контроллере КурсРегистрейшн будет метод для обработки этого запроса, который будет
    //возвращать Нашему сервису курс сет всех регистраций для этого курса, по его id
}
