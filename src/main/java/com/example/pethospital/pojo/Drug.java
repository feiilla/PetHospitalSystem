package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
    private int drugId; // 药品ID
    private String drugName; // 药品名称
    private int drugQuantity; // 药品数量
    private double drugPrice; // 药品价格
    private String drugDescription; // 药品描述
}
