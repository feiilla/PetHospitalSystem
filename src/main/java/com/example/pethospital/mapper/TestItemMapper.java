package com.example.pethospital.mapper;

import com.example.pethospital.pojo.TestItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestItemMapper {
    @Insert("INSERT INTO tb_test_item(test_item_name, test_item_description, test_item_price) VALUES (#{testItemName}, #{testItemDescription}, #{testItemPrice})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "testItemId", before = false, resultType = int.class)
    void addTestItem(TestItem testItem);

    @Select("SELECT * FROM tb_test_item")
    List<TestItem> selectAllTestItem();

    @Delete("DELETE FROM tb_test_item WHERE test_item_id = #{testItemId}")
    void deleteTestItemById(int testItemId);

    @Update("UPDATE tb_test_item SET test_item_name = #{testItemName}, test_item_description = #{testItemDescription}, test_item_price = #{testItemPrice} WHERE test_item_id = #{testItemId}")
    void updateTestItem(TestItem testItem);

    @Select("SELECT * FROM tb_test_item WHERE test_item_name = #{testItemName}")
    List<TestItem> selectByName(String testItemName);

    @Select("SELECT * FROM tb_test_item WHERE test_item_id = #{testItemId}")
    TestItem selectById(int testItemId);
}
