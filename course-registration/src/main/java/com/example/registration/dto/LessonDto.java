package com.example.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isAvailable;
    private TeacherDto teacher;
}
