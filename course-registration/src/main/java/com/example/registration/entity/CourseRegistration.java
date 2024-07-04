package com.example.registration.entity;
//Класс CourseRegistration играет ключевую роль в модели данных системы управления индивидуальными занятиями.
// Он служит связующим элементом между студентами (Student), преподавателями (Teacher) и курсами (Course).
// Вот основные функции класса CourseRegistration:
//Связывание студента с курсом и преподавателем: Этот класс создает связь между студентом,
// его выбранным курсом и преподавателем, что позволяет отслеживать, на какие курсы записан каждый
// студент и кто является преподавателем этих курсов.
//Управление расписанием: Поля в CourseRegistration, такие как scheduledTime, позволяют отслеживать
// расписание индивидуальных занятий для каждой регистрации.
//Гибкость изменений: Студенты могут менять курсы или преподавателей, и эти изменения будут
// отражены в соответствующих записях CourseRegistration.
//Этот класс обеспечивает централизованное управление информацией о занятиях, что является важным
// для эффективного функционирования системы управления обучением.
//создание сущностей юзер и CourseRegistration для регистрации пользователей на курсы
//разработка апи для записи пользователей на курсы с учетом выбранного времени
//тут же можно назначить дату первого пробного занятия (взаимодействие с
// планировщиком, то есть права доступа выдаются
//на 1 занятие, после его проведения производится оплата
//В контексте вашего приложения,
// микросервис Registration будет отвечать за регистрацию пользователей на курсы,
// управление данными регистрации, их валидацию и возможно, отправку уведомлений о
// предстоящих занятиях или изменениях в расписании.
        //Это централизует логику регистрации и делает её более управляемой
//После регистрации студента на курс, студенту, преподавателю должно приходить
//уведомление с датой  и временем пробного занятия

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

//    @Column(name = "teacher_id")//?
//    private Long teacherId;//?

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

}



