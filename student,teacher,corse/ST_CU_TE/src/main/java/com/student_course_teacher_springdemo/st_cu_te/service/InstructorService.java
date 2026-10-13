
package com.student_course_teacher_springdemo.st_cu_te.service;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;

import java.util.List;

public interface InstructorService {

    InstructorDto saveInstructor(InstructorDto instructorDto);

    InstructorDto updateInstructor(InstructorDto instructorDto);

    List<InstructorDto> getAllInstructors();

    void removeInstructor(Long id);

    InstructorDto getInstructorById(Long id);

    List<CourseDto> getCoursesByInstructorId(Long instructorId);
}
