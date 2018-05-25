package com.paul.blog.dao;

import com.paul.blog.model.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * @author xiaotiantian
 * @create 2018-05-25 9:47
 */
@Mapper
public interface LoginTicketDao {

    String TABLE_NAME = " login_ticket ";
    String INSERT_FIELDS = " user_id, ticket, expired, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userId},#{ticket},#{expired},#{status})"})
    void insertLoginTicket(LoginTicket loginTicket);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}"})
    LoginTicket selectById(Integer id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Update({"update", TABLE_NAME, "set status=#{status} where ticket=#{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") Integer status);

    @Delete({"delete from", TABLE_NAME, "where id=#{id}"})
    void deleteById(Integer id);
}
