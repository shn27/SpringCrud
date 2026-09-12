package com.javaGuides.SpringCrud.dto;


import jakarta.validation.constraints.*;

public class StudentRequest {
    @NotEmpty
    @Size(min = 3, max = 50)
    public String name;

    @Email
    public String email;

    @Max(25)
    @Min(18)
    public Long age;
}
