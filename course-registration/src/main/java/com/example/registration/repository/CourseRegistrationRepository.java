package com.example.registration.repository;

import com.example.registration.entity.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    Optional<CourseRegistration> findCourseRegistrationById (Long id);


    Set<CourseRegistration> findByCourseId(Long courseId);
}
