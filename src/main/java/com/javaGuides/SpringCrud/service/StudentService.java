package com.javaGuides.SpringCrud.service;

import com.javaGuides.SpringCrud.dto.StudentRequest;
import com.javaGuides.SpringCrud.dto.StudentResponse;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    StudentResponse save(StudentRequest student);
    StudentResponse getStudentById(UUID uuid);
    StudentResponse updateStudentById(UUID uuid,StudentRequest student);
    List<StudentResponse> getAllStudent();
    void deleteStudentById(UUID uuid);
}
