package com.student_course_teacher_springdemo.st_cu_te.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet = new HashSet<>();

    @ManyToOne
    private Instructor instructor;
}
