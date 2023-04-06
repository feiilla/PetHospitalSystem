package com.example.pethospital.mapper;

import com.example.pethospital.pojo.Patient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper{
    @Insert("INSERT INTO tb_patient(name, category, state, diagnose_process, result, treatment) VALUES (#{name}, #{category}, #{state}, #{diagnoseProcess}, #{result}, #{treatment})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "patientId", before = false, resultType = int.class)
    void addPatient(Patient patient);

    @Select("SELECT * FROM tb_patient")
    List<Patient> selectAllPatient();

    @Select("SELECT count(*) FROM tb_patient")
    int selectPatientCount();

    @Delete("DELETE FROM tb_patient WHERE question_id = #{questionId}")
    void deletePatientById(int id);

    @Select("SELECT * FROM tb_patient WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Patient> selectByNameLike(String name);

    @Select("SELECT * FROM tb_patient WHERE category = #{category}")
    List<Patient> selectByCategory(String category);

    @Update("UPDATE tb_patient SET name = #{name}, category = #{category}, state = #{state}, diagnose_process = #{diagnoseProcess}, result = #{result}, treatment = #{treatment} WHERE patient_id = #{patientId}")
    void updateById(Patient patient);

    @Select("SELECT * FROM tb_patient WHERE patient_id = #{patientId}")
    Patient selectById(int patientId);
}
