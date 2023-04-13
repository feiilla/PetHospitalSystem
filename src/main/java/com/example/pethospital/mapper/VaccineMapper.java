package com.example.pethospital.mapper;

import com.example.pethospital.pojo.Vaccine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VaccineMapper {
    // 添加疫苗
    @Insert("INSERT INTO tb_vaccine(vaccine_name, vaccine_quantity, vaccine_price, vaccine_description) VALUES(#{vaccineName}, #{vaccineQuantity}, #{vaccinePrice}, #{vaccineDescription})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "vaccineId", before = false, resultType = int.class)
    void addVaccine(Vaccine vaccine);

    // 获取全部疫苗
    @Select("SELECT * FROM tb_vaccine")
    List<Vaccine> selectAllVaccine();

    // 根据疫苗ID查询疫苗
    @Select("SELECT * FROM tb_vaccine WHERE vaccine_id=#{vaccineId}")
    Vaccine selectById(int vaccineId);

    // 根据疫苗名称模糊查询
    @Select("SELECT * FROM tb_vaccine WHERE vaccine_name like CONCAT('%',#{vaccineName},'%')")
    List<Vaccine> selectByNameLike(String vaccineName);

    // 根据疫苗ID删除疫苗
    @Delete("DELETE FROM tb_vaccine WHERE vaccine_id=#{vaccineId}")
    void deleteVaccineById(int vaccineId);

    // 更新疫苗信息
    @Update("UPDATE tb_vaccine SET vaccine_name=#{vaccineName}, vaccine_quantity=#{vaccineQuantity}, vaccine_price=#{vaccinePrice}, vaccine_description=#{vaccineDescription} WHERE vaccine_id=#{vaccineId}")
    void updateById(Vaccine vaccine);
}
