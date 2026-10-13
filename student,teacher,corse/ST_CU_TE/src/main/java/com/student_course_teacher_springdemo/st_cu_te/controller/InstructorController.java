
package com.student_course_teacher_springdemo.st_cu_te.controller;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;
import com.student_course_teacher_springdemo.st_cu_te.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public InstructorDto saveInstructor(@RequestBody InstructorDto instructorDto) {

        return instructorService.saveInstructor(instructorDto);
    }

    @PutMapping
    public InstructorDto updateInstructor(@RequestBody InstructorDto instructorDto) {

        return instructorService.updateInstructor(instructorDto);
    }

    @GetMapping
    public List<InstructorDto> getAllInstructors() {

        return instructorService.getAllInstructors();
    }

    @DeleteMapping("/{id}")
    public void removeInstructor(@PathVariable Long id) {

        instructorService.removeInstructor(id);
    }

    @GetMapping("/{id}")
    public InstructorDto getInstructorById(@PathVariable Long id) {

        return instructorService.getInstructorById(id);
    }

    @GetMapping("/{instructorId}/courses")
    public List<CourseDto> getCoursesByInstructorId(
            @PathVariable Long instructorId) {

        return instructorService.getCoursesByInstructorId(instructorId);
    }
}
