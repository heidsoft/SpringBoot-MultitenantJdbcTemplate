package com.tenancy.MultitenantJdbcTemplate.JDBC.Controller;

import java.util.List;

import com.tenancy.MultitenantJdbcTemplate.JDBC.Dao.UserDAO;
import com.tenancy.MultitenantJdbcTemplate.JDBC.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("multitenant")
public class UserController{

    @Autowired
    private UserDAO userDao;

    @GetMapping("users/{id}")
	public ResponseEntity<List<User>> getArticleById(@PathVariable("id") Integer id) {
        System.out.println("tge id "+id);
		List<User> user = userDao.getAllUsers();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

}