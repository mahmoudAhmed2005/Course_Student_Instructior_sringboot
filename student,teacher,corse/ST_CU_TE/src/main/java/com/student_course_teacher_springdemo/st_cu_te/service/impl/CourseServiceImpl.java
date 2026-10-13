package com.student_course_teacher_springdemo.st_cu_te.service.impl;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.mapper.CourseMapper;
import com.student_course_teacher_springdemo.st_cu_te.mapper.InstructorMapper;
import com.student_course_teacher_springdemo.st_cu_te.mapper.StudentMapper;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import com.student_course_teacher_springdemo.st_cu_te.model.Instructor;
import com.student_course_teacher_springdemo.st_cu_te.model.Student;
import com.student_course_teacher_springdemo.st_cu_te.repo.CourseRepo;
import com.student_course_teacher_springdemo.st_cu_te.repo.InstructorRepo;
import com.student_course_teacher_springdemo.st_cu_te.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;
    private InstructorRepo instructorRepo;
    private CourseMapper courseMapper;
    private StudentMapper studentMapper;
    private InstructorMapper instructorMapper;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, CourseMapper courseMapper, StudentMapper studentMapper, InstructorMapper instructorMapper,InstructorRepo instructorRepo) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
        this.studentMapper = studentMapper;
        this.instructorMapper = instructorMapper;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return toDto(courseRepo.save(course));
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {

        Course course = courseMapper.toEntity(courseDto);
        return toDto(courseRepo.save(course));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
//        return courseMapper.toDtoList(courseRepo.findAll());

        return courseRepo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public void removeCourse(Long id) {

        courseRepo.deleteById(id);

    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepo.findById(id).get();
        return toDto(course);
    }

    @Override
    public List<StudentDto> getStudentsByCourseId(Long courseId) {
        Course course = courseRepo.findById(courseId).get();

        return studentMapper.toDtoList(
                List.copyOf(course.getStudentSet())
        );
    }

    @Override
    public InstructorDto getInstructorByCourseId(Long courseId) {
       Course course = courseRepo.findById(courseId).get();
       return instructorMapper.toDto(course.getInstructor());
    }

    @Override
    @Transactional
    public void assignInstructorToCourse(Long courseId, Long instructorId) {
        Course course = courseRepo.findById(courseId).get();

        Instructor instructor = instructorRepo.findById(instructorId).get();

        course.setInstructor(instructor);

        courseRepo.save(course);
    }


    public CourseDto toDto(Course course) {

        CourseDto courseDto = courseMapper.toDto(course);

        courseDto.setStudentId(
                course.getStudentSet()
                        .stream()
                        .map(Student::getId)
                        .toList()
        );

        courseDto.setStudentName(
                course.getStudentSet()
                        .stream()
                        .map(Student::getName)
                        .toList()
        );

        if (course.getInstructor() != null) {
            courseDto.setInstructorId(course.getInstructor().getId());
            courseDto.setInstructorName(course.getInstructor().getName());
        }

        return courseDto;
    }
}
