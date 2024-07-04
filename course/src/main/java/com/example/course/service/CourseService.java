package com.example.course.service;

import com.example.course.dto.CourseDto;
import com.example.course.dto.CourseFullDto;
import java.util.List;

public interface CourseService {

     List<CourseDto> getAllCourses();

     CourseDto getCourseById (Long id);

     CourseFullDto getCourseWithRegistrations(Long courseId);

     CourseDto createCourse (CourseDto courseDto);

     CourseDto updateCourse (Long id, CourseDto courseDto);

     void deleteByIdCourse (Long id);





}
