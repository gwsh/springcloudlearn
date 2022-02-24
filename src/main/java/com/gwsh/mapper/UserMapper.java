package com.gwsh.mapper;

import com.gwsh.entities.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     *
     * @return 用户数组
     */
    @Select("select * from tb_user")
    List<User> getAllUsers();

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     */
    @Delete("delete from tb_user where id = #{id} ")
    void delete(Integer id);

}
