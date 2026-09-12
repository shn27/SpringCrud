package com.javaGuides.SpringCrud.controller;


import com.javaGuides.SpringCrud.dto.StudentRequest;
import com.javaGuides.SpringCrud.dto.StudentResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.javaGuides.SpringCrud.service.StudentService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/health")
    public String health() {
        return "Hello, Spring Boot!";
    }

    @PostMapping()
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request) {
        StudentResponse studentResponse = studentService.save(request);
        return new ResponseEntity<>( studentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable("id") String id,@Valid @RequestBody StudentRequest request) {
        UUID uuid = UUID.fromString(id);
        StudentResponse studentResponse = studentService.updateStudentById(uuid,request);
        return new ResponseEntity<>( studentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse>getStudentById(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        StudentResponse  studentResponse = studentService.getStudentById(uuid);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>>getStudent(){
        List< StudentResponse > studentResponses = studentService.getAllStudent();
        return new ResponseEntity<>(studentResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>deleteStudentById(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        studentService.deleteStudentById(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
