package com.example.registration.service;

import com.example.registration.dto.AvailableLessonDto;
import com.example.registration.dto.TeacherDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


public interface TeacherService {//почему все серое?

    TeacherDto registerTeacherWithAvailableSlots(TeacherDto teacherDto, Set<AvailableLessonDto> availableSlots);//для него сразу создается График уроков

//    ScheduleDto getScheduleForTeacher(Long teacherId);?
    List<TeacherDto> getAllTeachers();
    List<TeacherDto> findTeachersByAvailableSlots(List<LocalDateTime> slots);

    List<TeacherDto> getAvailableTeachers();

    TeacherDto getTeacherById (Long id);

    void deleteTeacher(Long id);
    TeacherDto updateTeacher (Long id);

}
