package com.example.course.controller;

import com.example.course.dto.CourseDto;
import com.example.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAllCourses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getCourse/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
       return  courseService.getCourseById(id);
    }

    @PostMapping("/createCourse")
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @PutMapping("/updateCourse/{id}")
        public CourseDto updateCourse (@PathVariable Long id, @RequestBody CourseDto courseDto) {
           return courseService.updateCourse(id, courseDto);
        }

    @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteByIdCourse(id);
    }


}
