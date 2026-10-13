package com.student_course_teacher_springdemo.st_cu_te.mapper;

import com.student_course_teacher_springdemo.st_cu_te.dto.StudentDto;
import com.student_course_teacher_springdemo.st_cu_te.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    List<Student> toEntityList (List<StudentDto>studentDtos);

    List<StudentDto> toDtoList (List<Student>students);
}
