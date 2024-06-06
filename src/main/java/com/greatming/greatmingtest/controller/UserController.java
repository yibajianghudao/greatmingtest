package com.greatming.greatmingtest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.greatming.greatmingtest.dao.User;
import com.greatming.greatmingtest.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {

    @Autowired
    private UserServiceimpl userServiceimpl;

    @GetMapping("/user/{id}")
    public User getStudentById(@PathVariable long id){
            return userServiceimpl.getUserById(id);
    }
    
}
