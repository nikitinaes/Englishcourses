package com.example.course.mapper;

import com.example.course.dto.CourseDto;
import com.example.course.dto.CourseFullDto;
import com.example.course.dto.CourseRegistrationDto;
import com.example.course.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "pricePerClass", target = "pricePerClass")
    CourseDto toDto(Course course);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "pricePerClass", target = "pricePerClass")
    Course toEntity(CourseDto courseDto);

    @Mapping(source = "course.id", target = "id")
    @Mapping(source = "course.name", target = "name")
    @Mapping(source = "course.description", target = "description")
    @Mapping(source = "course.pricePerClass", target = "pricePerClass")
    @Mapping (source = "registrations", target = "registrations")
    CourseFullDto toCourseFullDto(Course course, Set<CourseRegistrationDto> registrations);//из-а двух параметров

    List<CourseDto> toCourseDtoList(List<Course> courseList);
}
