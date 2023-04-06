package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病例
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private int patientId;  // 病例ID
    private String name;    // 病例名称
    private String category;    // 病种类别
    private String state;   // 接诊状态
    private String diagnoseProcess; // 诊疗过程和方法
    private String result;  // 诊断结果
    private String treatment;   // 治疗方案
}
