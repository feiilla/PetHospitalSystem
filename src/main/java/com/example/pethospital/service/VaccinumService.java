package com.example.pethospital.service;

import com.example.pethospital.pojo.Vaccinum;

import java.util.List;

public interface VaccinumService {
    // 添加疫苗
    void addVaccinum(Vaccinum vaccinum);

    // 获取全部疫苗
    List<Vaccinum> selectAllVaccinum();

    // 根据疫苗ID查询疫苗
    Vaccinum selectById(int vaccinumId);

    // 根据疫苗名称模糊查询
    List<Vaccinum> getVaccinumsByName(String vaccinumName);

    // 根据疫苗ID删除疫苗
    void deleteVaccinumById(int vaccinumId);

    // 更新疫苗信息
    void updateVaccinum(Vaccinum vaccinum);
}
