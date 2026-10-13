package com.student_course_teacher_springdemo.st_cu_te.repo;

import com.student_course_teacher_springdemo.st_cu_te.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    Optional<Student> findByEmail(String email);
}
