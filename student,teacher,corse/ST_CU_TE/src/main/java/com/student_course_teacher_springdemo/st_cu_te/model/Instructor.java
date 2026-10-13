package com.student_course_teacher_springdemo.st_cu_te.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Instructor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;

   @OneToMany(mappedBy = "instructor")
  private Set<Course>courseSet = new HashSet<>();
}
