package com.student_course_teacher_springdemo.st_cu_te.mapper;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import com.student_course_teacher_springdemo.st_cu_te.model.Student;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "٢٠٢٦-١٠-١٤T٠١:١٥:٤٨+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.20.1 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDto.getId() );
        student.setName( studentDto.getName() );
        student.setEmail( studentDto.getEmail() );
        student.setCourseSet( courseDtoSetToCourseSet( studentDto.getCourseSet() ) );

        return student;
    }

    @Override
    public StudentDto toDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setName( student.getName() );
        studentDto.setEmail( student.getEmail() );
        studentDto.setCourseSet( courseSetToCourseDtoSet( student.getCourseSet() ) );

        return studentDto;
    }

    @Override
    public List<Student> toEntityList(List<StudentDto> studentDtos) {
        if ( studentDtos == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( studentDtos.size() );
        for ( StudentDto studentDto : studentDtos ) {
            list.add( toEntity( studentDto ) );
        }

        return list;
    }

    @Override
    public List<StudentDto> toDtoList(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( Student student : students ) {
            list.add( toDto( student ) );
        }

        return list;
    }

    protected Course courseDtoToCourse(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDto.getId() );
        course.setTitle( courseDto.getTitle() );
        course.setDescription( courseDto.getDescription() );

        return course;
    }

    protected Set<Course> courseDtoSetToCourseSet(Set<CourseDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Course> set1 = new LinkedHashSet<Course>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CourseDto courseDto : set ) {
            set1.add( courseDtoToCourse( courseDto ) );
        }

        return set1;
    }

    protected CourseDto courseToCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setTitle( course.getTitle() );
        courseDto.setDescription( course.getDescription() );

        return courseDto;
    }

    protected Set<CourseDto> courseSetToCourseDtoSet(Set<Course> set) {
        if ( set == null ) {
            return null;
        }

        Set<CourseDto> set1 = new LinkedHashSet<CourseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Course course : set ) {
            set1.add( courseToCourseDto( course ) );
        }

        return set1;
    }
}
