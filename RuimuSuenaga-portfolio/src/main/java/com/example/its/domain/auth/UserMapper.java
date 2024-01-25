package com.example.its.domain.auth;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE username = #{username}")
    Optional<User> findByUsername(String username);

    @Select("SELECT * FROM users")
    List<User> findAll();

    // UserMapper.java
    @Insert("INSERT INTO users (username, password, authority) VALUES (#{username}, #{password}, #{authority})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);


    @Update("UPDATE users SET password = #{password}, authority = #{authority} WHERE username = #{username}")
    void update(User user);

    @Delete("DELETE FROM users WHERE username = #{username}")
    void delete(String username);

    @Select("SELECT * FROM users WHERE username LIKE #{keyword} OR authority LIKE #{keyword}")
    List<User> searchUsers(@Param("keyword") String keyword);
}