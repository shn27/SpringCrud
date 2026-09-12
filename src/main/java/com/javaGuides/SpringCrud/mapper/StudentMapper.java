package com.javaGuides.SpringCrud.mapper;

import com.javaGuides.SpringCrud.dto.StudentResponse;
import com.javaGuides.SpringCrud.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Tells Spring to manage this as a Bean
public interface StudentMapper {
    StudentResponse toDto(Student student);
}

/*
@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDto(Student student);

    Student toEntity(StudentDTO dto);
}
 */