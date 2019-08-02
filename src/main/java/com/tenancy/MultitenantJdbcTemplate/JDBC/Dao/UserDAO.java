package com.tenancy.MultitenantJdbcTemplate.JDBC.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tenancy.MultitenantJdbcTemplate.JDBC.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository
public class UserDAO{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<User> getAllUsers(){


        List<User> allUsers = new ArrayList<>();

        String queryTotal = "select id,name,rol from users";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(queryTotal);
 
            for (Map row : rows) {

                allUsers.add(new User(row.get("id").toString(),row.get("name").toString(),row.get("rol").toString()));
            }


        return allUsers;
    }



}