package com.example.course.service;

import com.example.course.dto.CourseDto;
import com.example.course.dto.CourseFullDto;
import com.example.course.dto.CourseRegistrationDto;
import com.example.course.entity.Course;
import com.example.course.mapper.CourseMapper;
import com.example.course.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRegistrationClient courseRegistrationClient;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        return courseMapper.toCourseDtoList(allCourses);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Course with ID " + id + " not found"));
    }

    @Override
    public CourseFullDto getCourseWithRegistrations(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course with ID "
                        + courseId + " not found"));
        Set<CourseRegistrationDto> registrations = courseRegistrationClient.getRegistrationsForCourse(courseId);

        return courseMapper.toCourseFullDto(course, registrations);
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course savedCourse = courseRepository.save(courseMapper.toEntity(courseDto));
        return courseMapper.toDto(savedCourse);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Optional<Course> courseForUpdate = courseRepository.findById(id);

        if (courseForUpdate.isPresent()) {
            Course updatedCourse = courseForUpdate.get();
            updatedCourse.setName(courseDto.getName());
            updatedCourse.setDescription(courseDto.getDescription());
            updatedCourse.setPricePerClass(courseDto.getPricePerClass());//
            Course savedCourse = courseRepository.save(updatedCourse);
             return courseMapper.toDto(savedCourse);
        } else {
             throw new EntityNotFoundException("Course with ID " + id + " not found");
        }
    }

    @Override
    public void deleteByIdCourse(Long id) {//
     courseRepository.deleteById(id);
    }


}
