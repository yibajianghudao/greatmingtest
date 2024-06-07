package com.greatming.greatmingtest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.greatming.greatmingtest.Response;
import com.greatming.greatmingtest.dto.UserDTO;
import com.greatming.greatmingtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Response<UserDTO> getStudentById(@PathVariable long id){
            return Response.newSuccess(userService.getUserById(id));
    }
    @PostMapping("/adduser")
    public Response<Long> addNewUser(@RequestBody UserDTO userDTO) {
        return Response.newSuccess(userService.addNewUser(userDTO));
    }
    

}
