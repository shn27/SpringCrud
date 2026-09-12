package com.javaGuides.SpringCrud.service;

import com.javaGuides.SpringCrud.dto.StudentRequest;
import com.javaGuides.SpringCrud.dto.StudentResponse;
import com.javaGuides.SpringCrud.entity.Student;
import com.javaGuides.SpringCrud.exception.ResourceNotFoundException;
import com.javaGuides.SpringCrud.mapper.StudentMapper;
import com.javaGuides.SpringCrud.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper){
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = new Student(
                studentRequest.name,
                studentRequest.email,
                studentRequest.age
        );
       Student student1 = studentRepo.save(student);
       return studentMapper.toDto(student1);
    }

    @Override
    public StudentResponse getStudentById(UUID uuid) {
        Student student = studentRepo.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: "+uuid));
        return studentMapper.toDto(student);
    }

    @Override
    public StudentResponse updateStudentById(UUID uuid,StudentRequest studentRequest) {
        Student student = studentRepo.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + uuid));
        student.setAge(studentRequest.age);
        student.setName(studentRequest.name);
        student.setEmail(studentRequest.email);

        studentRepo.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        List<StudentResponse> studentResponses = new java.util.ArrayList<>(List.of());

        for(int i = 0; i < students.size(); i++){
            studentResponses.add( studentMapper.toDto( students.get(i) ) );
        }

        return studentResponses;
    }

    @Override
    public void deleteStudentById(UUID uuid) {
        if(!studentRepo.existsById(uuid)) {
            throw new ResourceNotFoundException("Student does not exists by id: "+uuid);
        }
        studentRepo.deleteById(uuid);
        return;
    }
}
