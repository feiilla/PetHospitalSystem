package com.example.pethospital.service;

import com.example.pethospital.pojo.Drug;

import java.util.List;

public interface DrugService {

    void addDrug(Drug drug);

    void deleteDrugById(int drugId);

    void updateDrug(Drug drug);

    List<Drug> selectAllDrugs();

    List<Drug> getDrugsByName(String drugName);

    Drug selectDrugById(int drugId);
}
