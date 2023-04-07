package com.example.pethospital.mapper;

import com.example.pethospital.pojo.Drug;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DrugMapper {

    @Insert("INSERT INTO tb_drug(drug_name, drug_quantity, drug_price, drug_description) VALUES (#{drugName}, #{drugQuantity}, #{drugPrice}, #{drugDescription})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "drugId", before = false, resultType = int.class)
    void addDrug(Drug drug);

    @Delete("DELETE FROM tb_drug WHERE drug_id = #{drugId}")
    void deleteDrugById(int drugId);

    @Update("UPDATE tb_drug SET drug_name = #{drugName}, drug_quantity = #{drugQuantity}, drug_price = #{drugPrice}, drug_description = #{drugDescription} WHERE drug_id = #{drugId}")
    void updateDrug(Drug drug);

    @Select("SELECT * FROM tb_drug")
    List<Drug> selectAllDrugs();

    @Select("SELECT * FROM tb_drug WHERE drug_name LIKE CONCAT('%',#{drugName},'%')")
    List<Drug> selectDrugsByName(String drugName);

    @Select("SELECT * FROM tb_drug WHERE drug_id = #{drugId}")
    Drug selectDrugById(int drugId);
}
