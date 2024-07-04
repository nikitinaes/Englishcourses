package com.example.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

//Содержит информацию о доступных курсах, стоимости за 1 занятие,
// преподавателях, преподающих данных курс - в регистрации менеджер
//сообщает, из каких преподавателей можно выбрать (у него есть инфо
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String name;
    @Column(name = "course_description")
    private String description;
    @Column(name = "course_price")
    private BigDecimal pricePerClass;


}
