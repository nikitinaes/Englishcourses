package com.example.registration.mapper;

import com.example.registration.dto.CourseRegistrationDto;
import com.example.registration.entity.CourseRegistration;
import org.mapstruct.Mapper;//today
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LessonMapper.class})
public interface CourseRegistrationMapper {

    @Mapping (source = "id", target = "id")
    @Mapping (source = "courseId", target = "courseId")
    @Mapping (source = "student", target = "student")
    @Mapping (source = "teacher", target = "teacher")
    @Mapping (source = "registeredAt", target = "registeredAt")
    CourseRegistrationDto toDto(CourseRegistration courseRegistration);

    @Mapping (source = "id", target = "id")
    @Mapping (source = "courseId", target = "courseId")
    @Mapping (source = "student", target = "student")
    @Mapping (source = "teacher", target = "teacher")
    @Mapping (source = "registeredAt", target = "registeredAt")
    CourseRegistration toEntity(CourseRegistrationDto courseRegistrationDto);

}
