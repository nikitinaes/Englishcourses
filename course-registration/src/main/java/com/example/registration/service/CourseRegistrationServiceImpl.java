package com.example.registration.service;

import com.example.registration.dto.CourseRegistrationDto;
import com.example.registration.dto.TeacherDto;
import com.example.registration.entity.CourseRegistration;
import com.example.registration.mapper.CourseRegistrationMapper;
import com.example.registration.repository.CourseRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;

    private final CourseRegistrationMapper courseRegistrationMapper;

    private final TeacherService teacherService;


    @Override
    public Set<CourseRegistrationDto> getRegistrationsForCourse(Long courseId) {
        Set<CourseRegistration> registrations = courseRegistrationRepository.findByCourseId(courseId);
        return registrations.stream()
                .map(courseRegistrationMapper::toDto)
                .collect(Collectors.toSet());

    }
//    //В этом методе мы будем производить собственно регистрацию на курсы
//
    public CourseRegistration registerStudentForCourse(Long studentId, Long courseId,
                                                       List<LocalDateTime> requestedSlots, Long teacherId) {
        // Получаем доступных преподавателей для запрашиваемых слотов
//        List<TeacherDto> availableTeachers = getAvailableTeachersForStudentSlots(studentId, requestedSlots);
        List<TeacherDto> availableTeachers = teacherService.findTeachersByAvailableSlots(requestedSlots);


        // Проверяем, есть ли доступные преподаватели
//        if (availableTeachers.isEmpty()) {
//            throw new NoAvailableTeachersException("No teachers available for the requested slots.");
//        }

        //Из этого листа нам нужно вытащить конкретного учителя по его id
        TeacherDto selectedTeacher = selectTeacherById(availableTeachers, teacherId);

        // Создаем запись регистрации курса
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(courseId);
   //     courseRegistration.setStudent(studentService.getStudentById(studentId)); Нужно сервис студента
    //    courseRegistration.setTeacher(teacherService.getTeacherById(selectedTeacher.getId())); тут нужен маппер
        courseRegistration.setRegisteredAt(LocalDateTime.now());
        // Отправляем информацию о новой регистрации в микросервис Schedule
       // scheduleServiceClient.updateSchedule(selectedTeacher.getId(), studentId, requestedSlots); надо у учителя заюронировать
        //слоты и у студента
        // Сохраняем регистрацию в базе данных
        return courseRegistrationRepository.save(courseRegistration);
    }
        public TeacherDto selectTeacherById(List<TeacherDto> availableTeachers, Long teacherId) {
            return availableTeachers.stream()
                    .filter(teacher -> teacher.getId().equals(teacherId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Учитель с таким ID не найден"));
        }


}


