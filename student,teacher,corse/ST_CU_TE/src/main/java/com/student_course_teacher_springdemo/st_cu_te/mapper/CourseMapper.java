package com.student_course_teacher_springdemo.st_cu_te.mapper;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import com.student_course_teacher_springdemo.st_cu_te.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseDto courseDto);

    CourseDto toDto(Course course);

    List<Course> toEntityList (List<CourseDto>courseDtos);

    List<CourseDto> toDtoList (List<Course>courses);
}
