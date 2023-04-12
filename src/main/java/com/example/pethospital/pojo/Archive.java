package com.example.pethospital.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 宠物档案实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Archive {
    private int archiveId; // 档案ID
    private String archiveName; // 档案名称
    private String archiveDescription; // 档案描述
    private String archivePayRecord; // 档案收费记录
}
