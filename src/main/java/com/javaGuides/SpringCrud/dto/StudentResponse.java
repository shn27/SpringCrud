package com.javaGuides.SpringCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private UUID uuid;
    private String name;
    private String email;
    private Long age;
}
