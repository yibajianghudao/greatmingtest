package com.greatming.greatmingtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatming.greatmingtest.dao.User;
import com.greatming.greatmingtest.dao.UserRepository;

@Service
public class UserServiceimpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
