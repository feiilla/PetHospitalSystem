package com.example.pethospital.mapper;

import com.example.pethospital.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into tb_user(user_name, user_pass, user_privilege) VALUES (#{userName}, #{userPass}, #{userPrivilege})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "userId", before = false, resultType = long.class)
    void addUser(User user);

    @Select("select * from tb_user")
    List<User> selectAllUser();

    @Select("select * from tb_user where user_id = #{userId}")
    User selectUserById(long id);

    @Select("select count(*) from tb_user")
    int selectUserCount();

    @Delete("delete from tb_user where user_id = #{userId}")
    void deleteUserById(long id);
}
