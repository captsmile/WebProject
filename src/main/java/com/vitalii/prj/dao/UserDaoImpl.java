package com.vitalii.prj.dao;

import com.vitalii.prj.entity.User;
import com.vitalii.prj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        String sql ="SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public void save( User user ) {
        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    public User getById( int id ) {
        String sql = "SELECT * FROM users WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    public void delete( int id ) {
        String sql="DELETE FROM  users WHERE id =?";
        jdbcTemplate.update(sql,id);
    }

    public void update( User user ) {
        String sql = "UPDATE users SET name=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }
}
