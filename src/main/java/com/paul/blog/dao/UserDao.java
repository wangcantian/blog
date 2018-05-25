package com.paul.blog.dao;

import com.paul.blog.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author xiaotiantian
 * @create 2018-05-24 18:00
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name, password, salt, head_url, role ";
    String SELECT_FIELDS = " id " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{name},#{password},#{salt},#{headUrl},#{role}))"})
    void insertUser(User user);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}"})
    User selectById(Integer id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where name=#{name}"})
    User selectByName(@Param("name") String name);

    @Delete({"delete from", TABLE_NAME, "where id=#{id}"})
    void deleteById(Integer id);
}
