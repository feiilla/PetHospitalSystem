package com.example.pethospital.service;

import com.example.pethospital.pojo.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);

    List<Patient> selectAllPatient();

    int selectPatientCount();

    void deletePatientById(int id);

    void updatePatient(Patient patient);

    List<Patient> getPatientsByName(String name);

    List<Patient> getPatientsByCategory(String category);

    Patient selectById(int patientId);
}
