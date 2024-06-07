package com.greatming.greatmingtest.service;


import com.greatming.greatmingtest.dto.UserDTO;

public interface UserServiceimpl {
    
    public UserDTO getUserById(long id);
    public Long addNewUser(UserDTO userDTO);
}
