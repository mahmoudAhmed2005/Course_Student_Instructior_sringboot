package com.student_course_teacher_springdemo.st_cu_te.mapper;

import com.student_course_teacher_springdemo.st_cu_te.dto.CourseDto;
import com.student_course_teacher_springdemo.st_cu_te.dto.InstructorDto;
import com.student_course_teacher_springdemo.st_cu_te.model.Course;
import com.student_course_teacher_springdemo.st_cu_te.model.Instructor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    Instructor toEntity(InstructorDto instructorDto);

    InstructorDto toDto(Instructor instructor);

    List<Instructor> toEntityList (List<InstructorDto>instructorDtos);

    List<InstructorDto> toDtoList (List<Instructor>instructors);
}
