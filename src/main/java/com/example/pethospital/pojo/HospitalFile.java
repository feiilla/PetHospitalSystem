package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalFile {
    private int fileId;
    private String path;
    private String originName;
    private Timestamp time;
    private int size;
}
