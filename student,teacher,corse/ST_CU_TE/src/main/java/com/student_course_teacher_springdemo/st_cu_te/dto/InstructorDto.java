package com.student_course_teacher_springdemo.st_cu_te.dto;

import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InstructorDto {


    private Long id;
    private String name;
    private String email;


  private Set<CourseDto>courseSet = new HashSet<>();
}
