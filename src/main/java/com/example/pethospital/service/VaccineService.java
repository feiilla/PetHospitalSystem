package com.example.pethospital.service;

import com.example.pethospital.pojo.Vaccine;

import java.util.List;

public interface VaccineService {
    // 添加疫苗
    void addVaccine(Vaccine vaccine);

    // 获取全部疫苗
    List<Vaccine> selectAllVaccine();

    // 根据疫苗ID查询疫苗
    Vaccine selectById(int vaccineId);

    // 根据疫苗名称模糊查询
    List<Vaccine> getVaccinesByName(String vaccineName);

    // 根据疫苗ID删除疫苗
    void deleteVaccineById(int vaccineId);

    // 更新疫苗信息
    void updateVaccine(Vaccine vaccine);
}
