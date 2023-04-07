package com.example.pethospital.mapper;

import com.example.pethospital.pojo.Vaccinum;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VaccinumMapper {
    // 添加疫苗
    @Insert("INSERT INTO tb_vaccinum(vaccinumName, vaccinumQuantity, vaccinumPrice, vaccinumDescription) VALUES(#{vaccinumName}, #{vaccinumQuantity}, #{vaccinumPrice}, #{vaccinumDescription})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "vaccinumId", before = false, resultType = int.class)
    void addVaccinum(Vaccinum vaccinum);

    // 获取全部疫苗
    @Select("SELECT * FROM tb_vaccinum")
    List<Vaccinum> selectAllVaccinum();

    // 根据疫苗ID查询疫苗
    @Select("SELECT * FROM tb_vaccinum WHERE vaccinumId=#{vaccinumId}")
    Vaccinum selectById(int vaccinumId);

    // 根据疫苗名称模糊查询
    @Select("SELECT * FROM tb_vaccinum WHERE vaccinumName like CONCAT('%',#{vaccinumName},'%')")
    List<Vaccinum> selectByNameLike(String vaccinumName);

    // 根据疫苗ID删除疫苗
    @Delete("DELETE FROM tb_vaccinum WHERE vaccinumId=#{vaccinumId}")
    void deleteVaccinumById(int vaccinumId);

    // 更新疫苗信息
    @Update("UPDATE tb_vaccinum SET vaccinumName=#{vaccinumName}, vaccinumQuantity=#{vaccinumQuantity}, vaccinumPrice=#{vaccinumPrice}, vaccinumDescription=#{vaccinumDescription} WHERE vaccinumId=#{vaccinumId}")
    void updateById(Vaccinum vaccinum);
}
