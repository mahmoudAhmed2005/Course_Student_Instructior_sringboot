package com.student_course_teacher_springdemo.st_cu_te.service;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {

    CourseDto saveCourse(CourseDto courseDto);

    CourseDto updateCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    void removeCourse(Long id);

    CourseDto getCourseById(Long id);


    List<StudentDto> getStudentsByCourseId(Long courseId);


    InstructorDto getInstructorByCourseId(Long courseId);

    void assignInstructorToCourse(Long courseId, Long instructorId);
}
