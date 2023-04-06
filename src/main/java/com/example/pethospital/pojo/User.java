package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private int authority;
    @NotBlank
    private String gender;
    @NotBlank
    private int age;
}
