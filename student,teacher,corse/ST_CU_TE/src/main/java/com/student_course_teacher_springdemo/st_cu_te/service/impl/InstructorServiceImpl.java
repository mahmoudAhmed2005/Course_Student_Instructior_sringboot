
package com.student_course_teacher_springdemo.st_cu_te.service.impl;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;

import com.student_course_teacher_springdemo.st_cu_te.mapper.CourseMapper;
import com.student_course_teacher_springdemo.st_cu_te.mapper.InstructorMapper;

import com.student_course_teacher_springdemo.st_cu_te.model.Instructor;
import com.student_course_teacher_springdemo.st_cu_te.repo.InstructorRepo;
import com.student_course_teacher_springdemo.st_cu_te.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepo instructorRepo;
    private InstructorMapper instructorMapper;
    private CourseMapper courseMapper;

    @Autowired
    public InstructorServiceImpl(
            InstructorRepo instructorRepo,
            InstructorMapper instructorMapper,
            CourseMapper courseMapper) {

        this.instructorRepo = instructorRepo;
        this.instructorMapper = instructorMapper;
        this.courseMapper = courseMapper;
    }

    @Override
    public InstructorDto saveInstructor(InstructorDto instructorDto) {

        Instructor instructor = instructorMapper.toEntity(instructorDto);

        return toDto(instructorRepo.save(instructor));
    }

    @Override
    public InstructorDto updateInstructor(InstructorDto instructorDto) {

        Instructor instructor = instructorMapper.toEntity(instructorDto);

        return toDto(instructorRepo.save(instructor));
    }

    @Override
    public List<InstructorDto> getAllInstructors() {

        return instructorMapper.toDtoList(instructorRepo.findAll());
    }

    @Override
    public void removeInstructor(Long id) {

        instructorRepo.deleteById(id);
    }

    @Override
    public InstructorDto getInstructorById(Long id) {

        Instructor instructor = instructorRepo.findById(id).get();

        return toDto(instructor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getCoursesByInstructorId(Long instructorId) {

        Instructor instructor = instructorRepo.findById(instructorId).get();

        return courseMapper.toDtoList(
                List.copyOf(instructor.getCourseSet())
        );
    }

    public InstructorDto toDto(Instructor instructor) {

        return instructorMapper.toDto(instructor);
    }
}
