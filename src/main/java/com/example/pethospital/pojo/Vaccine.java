package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 疫苗实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {
    private int vaccineId; // 疫苗ID
    private String vaccineName; // 疫苗名称
    private int vaccineQuantity; // 疫苗数量
    private float vaccinePrice; // 疫苗价格
    private String vaccineDescription; // 疫苗描述
}
