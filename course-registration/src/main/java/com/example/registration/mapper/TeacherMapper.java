package com.example.registration.mapper;

import com.example.registration.dto.TeacherDto;
import com.example.registration.entity.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LessonMapper.class, CourseRegistrationMapper.class})
public interface TeacherMapper {

    TeacherDto teacherToTeacherDto(Teacher teacher);

    @InheritInverseConfiguration
    Teacher teacherDtoToTeacher(TeacherDto teacherDto);

    List<TeacherDto> teachersToTeacherDtoList(List<Teacher> teachers);
}
