package com.javaGuides.SpringCrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Long age;
    @Column(name="email")
    private String email;

    public Student(@NotEmpty @Size(min = 3, max = 50) String name, @Email String email, @Max(25) @Min(18) Long age) {
        this.age = age;
        this.email = email;
        this.name = name;
    }
}
