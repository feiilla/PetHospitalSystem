package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalFile {
    private int fileId;
    @NotBlank
    private String path;
    @NotBlank
    private String originName;
    @NotBlank
    private Timestamp time;
    @NotBlank
    private int size;
}
