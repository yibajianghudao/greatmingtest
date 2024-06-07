package com.greatming.greatmingtest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.greatming.greatmingtest.Response;
import com.greatming.greatmingtest.dto.UserDTO;
import com.greatming.greatmingtest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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
    @DeleteMapping("/deluser/{id}")
    public Response<Void> delUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return Response.newSuccess(null);
    }
    @PutMapping("updateuser/{id}")
    public Response<UserDTO> updateUserById(@PathVariable long id, @RequestBody UserDTO userDTO) {
        // 此API不应传输passwd参数
        UserDTO userUpdateDTO = userService.updateUserById(id, userDTO);
        return Response.newSuccess(userUpdateDTO);
    }
    
    

}
