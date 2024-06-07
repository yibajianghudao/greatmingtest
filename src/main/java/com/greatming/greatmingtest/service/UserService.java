package com.greatming.greatmingtest.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatming.greatmingtest.converter.UserConverter;
import com.greatming.greatmingtest.dao.User;
import com.greatming.greatmingtest.dao.UserRepository;
import com.greatming.greatmingtest.dto.UserDTO;

@Service
public class UserService implements UserServiceimpl {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return UserConverter.converterUser(user);
    }

    public Long addNewUser(UserDTO userDTO) {
        List<User> userList  = userRepository.findByName(userDTO.getName());
        if (!org.springframework.util.CollectionUtils.isEmpty(userList)){
            throw new IllegalStateException("name:" + userDTO.getName() + " is bew used.");
        }
        User user = UserConverter.converterUserDTO(userDTO);
        LocalDateTime now = LocalDateTime.now();
        user.setCreatetime(Timestamp.valueOf(now));
        // 无法在此处添加Updatetime，数据库会在更新的时候自动添加（调用API没有尝试过）
        User addUser = userRepository.save(user);
        return addUser.getId();
    }
}
