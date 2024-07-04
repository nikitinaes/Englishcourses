package com.example.registration.repository;

import com.example.registration.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository <Lesson, Long> {
   @Override
    Optional<Lesson> findById(Long id);

    List<Lesson> findByTeacherId(Long teacherId);
}
