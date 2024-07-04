package com.example.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFullDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal pricePerClass;//?
    private Set<CourseRegistrationDto> registrations;

}

