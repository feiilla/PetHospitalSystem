package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 化验项目
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestItem {
    private int testItemId; // 化验项目ID
    private String testItemName; // 化验项目名称
    private String testItemDescription; // 化验项目描述
    private double testItemPrice; // 化验项目价格
}
