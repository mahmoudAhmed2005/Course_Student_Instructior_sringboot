package com.student_course_teacher_springdemo.st_cu_te.mapper;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "٢٠٢٦-١٠-١٤T٠١:١٥:٤٨+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.20.1 (Eclipse Adoptium)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toEntity(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDto.getId() );
        course.setTitle( courseDto.getTitle() );
        course.setDescription( courseDto.getDescription() );

        return course;
    }

    @Override
    public CourseDto toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setTitle( course.getTitle() );
        courseDto.setDescription( course.getDescription() );

        return courseDto;
    }

    @Override
    public List<Course> toEntityList(List<CourseDto> courseDtos) {
        if ( courseDtos == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( courseDtos.size() );
        for ( CourseDto courseDto : courseDtos ) {
            list.add( toEntity( courseDto ) );
        }

        return list;
    }

    @Override
    public List<CourseDto> toDtoList(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDto> list = new ArrayList<CourseDto>( courses.size() );
        for ( Course course : courses ) {
            list.add( toDto( course ) );
        }

        return list;
    }
}
