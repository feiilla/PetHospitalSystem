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
public class Vaccinum {
    private int vaccinumId; // 疫苗ID
    private String vaccinumName; // 疫苗名称
    private int vaccinumQuantity; // 疫苗数量
    private float vaccinumPrice; // 疫苗价格
    private String vaccinumDescription; // 疫苗描述
}
