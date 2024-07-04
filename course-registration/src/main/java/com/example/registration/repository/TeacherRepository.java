package com.example.registration.repository;

import com.example.registration.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Long> {

    Optional<Teacher> findTeacherById(Long id);
}
