package com.example.registration.service;

import com.example.registration.dto.AvailableLessonDto;
import com.example.registration.dto.TeacherDto;
import com.example.registration.entity.Lesson;
import com.example.registration.entity.Teacher;
import com.example.registration.mapper.LessonMapper;
import com.example.registration.mapper.TeacherMapper;
import com.example.registration.repository.LessonRepository;
import com.example.registration.repository.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;//ничего, что сет используется?
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final TeacherMapper teacherMapper;

    @Transactional
    @Override
    public TeacherDto registerTeacherWithAvailableSlots(TeacherDto teacherDto, Set<AvailableLessonDto> availableSlots) {

        Teacher savedTeacher = teacherRepository.save(teacherMapper.teacherDtoToTeacher(teacherDto));
        for (AvailableLessonDto lessonDto: availableSlots) {
            //Обработка и сохранение временных слотов, сообщенных учителем
            Lesson lesson = lessonMapper.toLesson(lessonDto, savedTeacher);
            lesson.setTeacher(savedTeacher);
            lesson.setAvailable(true);
            lessonRepository.save(lesson);
        }
        return teacherMapper.teacherToTeacherDto(savedTeacher);
    }


//остальное тоже проверить
    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.teachersToTeacherDtoList(teachers);
    }


    //отобразить список учителей, принимающих новых студентов, нужен он или нет, на всякий случай написала
    @Override
    public List<TeacherDto> getAvailableTeachers() {
        List<Teacher> allAvailableTeachers = teacherRepository.findAll()
                .stream().filter(t -> !t.isClosedForNewStudents()).toList();
        return teacherMapper.teachersToTeacherDtoList(allAvailableTeachers);
    }

    @Transactional(readOnly = true)
    //отобразить список учителей, доступных для выбранных слотов, очень не уверена
    @Override
    public List<TeacherDto> findTeachersByAvailableSlots(List<LocalDateTime> slots) {
        List<Teacher> teachersForSelectedSlots = teacherRepository.findAll();
        return teachersForSelectedSlots.stream()
                .filter(t -> !t.isClosedForNewStudents() && t.getLessons().stream()
                        .anyMatch(lesson -> slots.contains(lesson.getStartTime()) && lesson.isAvailable()))
                .map(teacherMapper::teacherToTeacherDto)
                .collect(Collectors.toList());
    }

   @Override
    public TeacherDto getTeacherById(Long id) {
       return  teacherRepository.findTeacherById(id).map(teacherMapper::teacherToTeacherDto)
               .orElseThrow(() ->new EntityNotFoundException("Teacher not found with ID: " + id));
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDto updateTeacher(Long id) {

        return null;//дописать
    }


}
