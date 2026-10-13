package com.student_course_teacher_springdemo.st_cu_te.service.impl;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.mapper.CourseMapper;
import com.student_course_teacher_springdemo.st_cu_te.mapper.StudentMapper;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import com.student_course_teacher_springdemo.st_cu_te.model.Student;
import com.student_course_teacher_springdemo.st_cu_te.repo.CourseRepo;
import com.student_course_teacher_springdemo.st_cu_te.repo.StudentRepo;
import com.student_course_teacher_springdemo.st_cu_te.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {

    private StudentRepo studentRepo;
    private StudentMapper studentMapper;
    private CourseMapper courseMapper;
    private CourseRepo courseRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper, CourseMapper courseMapper,CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
        this.courseMapper = courseMapper;
        this.courseRepo = courseRepo;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        return toDto(studentRepo.save(student));
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        return toDto(studentRepo.save(student));
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return studentMapper.toDtoList(studentRepo.findAll());
    }

    @Override
    public void removeStudent(Long id) {
      studentRepo.deleteById(id);
    }

    @Override
    public StudentDto getStudentByID(Long id) {
        Student student = studentRepo.findById(id).get();
        return toDto(student);

    }

    @Override
    public List<CourseDto> getCoursesByStudentId(Long studentId) {
        Student student = studentRepo.findById(studentId).get();

        return courseMapper.toDtoList(
                List.copyOf(student.getCourseSet())
        );
    }

    @Override
    @Transactional
    public void registerStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).get();

        Course course = courseRepo.findById(courseId).get();

        student.getCourseSet().add(course);

        studentRepo.save(student);
    }


    public StudentDto toDto(Student student){
        return studentMapper.toDto(student);
}
}
