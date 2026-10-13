package com.student_course_teacher_springdemo.st_cu_te.mapper;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import com.student_course_teacher_springdemo.st_cu_te.model.Instructor;
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
public class InstructorMapperImpl implements InstructorMapper {

    @Override
    public Instructor toEntity(InstructorDto instructorDto) {
        if ( instructorDto == null ) {
            return null;
        }

        Instructor instructor = new Instructor();

        instructor.setId( instructorDto.getId() );
        instructor.setName( instructorDto.getName() );
        instructor.setEmail( instructorDto.getEmail() );
        instructor.setCourseSet( courseDtoSetToCourseSet( instructorDto.getCourseSet() ) );

        return instructor;
    }

    @Override
    public InstructorDto toDto(Instructor instructor) {
        if ( instructor == null ) {
            return null;
        }

        InstructorDto instructorDto = new InstructorDto();

        instructorDto.setId( instructor.getId() );
        instructorDto.setName( instructor.getName() );
        instructorDto.setEmail( instructor.getEmail() );
        instructorDto.setCourseSet( courseSetToCourseDtoSet( instructor.getCourseSet() ) );

        return instructorDto;
    }

    @Override
    public List<Instructor> toEntityList(List<InstructorDto> instructorDtos) {
        if ( instructorDtos == null ) {
            return null;
        }

        List<Instructor> list = new ArrayList<Instructor>( instructorDtos.size() );
        for ( InstructorDto instructorDto : instructorDtos ) {
            list.add( toEntity( instructorDto ) );
        }

        return list;
    }

    @Override
    public List<InstructorDto> toDtoList(List<Instructor> instructors) {
        if ( instructors == null ) {
            return null;
        }

        List<InstructorDto> list = new ArrayList<InstructorDto>( instructors.size() );
        for ( Instructor instructor : instructors ) {
            list.add( toDto( instructor ) );
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
