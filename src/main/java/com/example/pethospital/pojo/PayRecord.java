package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayRecord {
    private int recordId;
    private Timestamp time;
    private String personName;
    private String information;
    private double totalCost;
}
