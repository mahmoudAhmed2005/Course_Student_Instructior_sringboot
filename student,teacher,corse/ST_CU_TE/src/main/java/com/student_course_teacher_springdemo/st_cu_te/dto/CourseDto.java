package com.student_course_teacher_springdemo.st_cu_te.dto;

import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {



    private Long id;
    private String title;
    private String description;


    private Long instructorId;
    private String instructorName;

    private List<Long>studentId = new ArrayList<>();
    private List<String>studentName = new ArrayList<>();

}
