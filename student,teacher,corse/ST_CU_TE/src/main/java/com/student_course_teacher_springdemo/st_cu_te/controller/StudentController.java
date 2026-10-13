package com.student_course_teacher_springdemo.st_cu_te.controller;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) {

        return studentService.saveStudent(studentDto);
    }

    @PutMapping

    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {

        return studentService.updateStudent(studentDto);
    }


    @GetMapping
    public List<StudentDto> getAllStudent() {

        return studentService.getAllStudent();
    }


    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable Long id) {

        studentService.removeStudent(id);
    }



    @GetMapping("/{id}")
    public StudentDto getStudentByID(@PathVariable Long id) {

        return studentService.getStudentByID(id);
    }



    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCoursesByStudentId(
            @PathVariable Long studentId) {

        return studentService.getCoursesByStudentId(studentId);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public void registerStudentToCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        studentService.registerStudentToCourse(studentId, courseId);
}
}
