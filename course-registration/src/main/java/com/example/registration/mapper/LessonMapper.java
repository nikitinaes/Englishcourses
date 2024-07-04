package com.example.registration.mapper;

import com.example.registration.dto.LessonDto;
import com.example.registration.dto.AvailableLessonDto;
import com.example.registration.entity.Lesson;
import com.example.registration.entity.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class})
public interface LessonMapper {

    @Mapping(target = "teacher", source = "teacher")
    LessonDto lessonToLessonDto(Lesson lesson);

    @InheritInverseConfiguration
    Lesson lessonDtoToLesson(LessonDto lessonDto);

    @Mapping(target = "teacher", source = "teacher")
    Lesson toLesson (AvailableLessonDto lessonDto, Teacher teacher);
}