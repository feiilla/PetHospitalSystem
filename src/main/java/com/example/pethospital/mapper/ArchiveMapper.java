package com.example.pethospital.mapper;

import com.example.pethospital.pojo.Archive;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArchiveMapper {

    @Insert("INSERT INTO tb_archive(archive_name, archive_description, archive_pay_record) VALUES (#{archiveName}, #{archiveDescription}, #{archivePayRecord})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "archiveId", before = false, resultType = int.class)
    void addArchive(Archive archive);

    @Select("SELECT * FROM tb_archive")
    List<Archive> selectAllArchive();

    @Select("SELECT count(*) FROM tb_archive")
    int selectArchiveCount();

    @Delete("DELETE FROM tb_archive WHERE archive_id = #{archiveId}")
    void deleteArchiveById(int archiveId);

    @Update("UPDATE tb_archive SET archive_name = #{archiveName}, archive_description = #{archiveDescription}, archive_pay_record = #{archivePayRecord} WHERE archive_id = #{archiveId}")
    void updateById(Archive archive);

    @Select("SELECT * FROM tb_archive WHERE archive_name LIKE CONCAT('%',#{archiveName},'%')")
    List<Archive> selectByNameLike(String archiveName);

    @Select("SELECT * FROM tb_archive WHERE archive_id = #{archiveId}")
    Archive selectById(int archiveId);
}
