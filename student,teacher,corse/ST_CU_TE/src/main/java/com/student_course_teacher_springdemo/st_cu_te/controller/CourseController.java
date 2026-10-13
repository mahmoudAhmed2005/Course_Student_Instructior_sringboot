package com.student_course_teacher_springdemo.st_cu_te.controller;


import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {

        return courseService.saveCourse(courseDto);
    }


    @PutMapping
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {

        return courseService.updateCourse(courseDto);
    }



    @GetMapping
    public List<CourseDto> getAllCourses() {

        return courseService.getAllCourses();
    }



    @DeleteMapping("/{id}")
    public void removeCourse(@PathVariable Long id) {

        courseService.removeCourse(id);
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {

        return courseService.getCourseById(id);
    }

    @GetMapping("/{courseId}/students")
    public List<StudentDto> getStudentsByCourseId(@PathVariable Long courseId) {


        return courseService.getStudentsByCourseId(courseId);
    }

    @GetMapping("/{courseId}/instructor")
    public InstructorDto getInstructorByCourseId(@PathVariable Long courseId) {


        return courseService.getInstructorByCourseId(courseId);
    }

    @PutMapping("/{courseId}/instructor/{instructorId}")
    public void assignInstructorToCourse(
            @PathVariable Long courseId,
            @PathVariable Long instructorId) {

        courseService.assignInstructorToCourse(courseId, instructorId);
    }
}
