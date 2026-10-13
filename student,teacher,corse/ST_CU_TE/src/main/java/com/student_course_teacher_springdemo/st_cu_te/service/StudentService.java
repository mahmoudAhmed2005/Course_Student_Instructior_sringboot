package com.student_course_teacher_springdemo.st_cu_te.service;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    StudentDto saveStudent(StudentDto studentDto);
    StudentDto updateStudent(StudentDto studentDto);
    List<StudentDto>getAllStudent();
    void removeStudent(Long id);
    StudentDto getStudentByID(Long id);

    List<CourseDto> getCoursesByStudentId(Long studentId) ;

  void registerStudentToCourse(Long studentId, Long courseId);
}
