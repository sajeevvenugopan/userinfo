package com.foodservice.userinfo.service;

import com.foodservice.userinfo.dto.UserDTO;
import com.foodservice.userinfo.entity.User;
import com.foodservice.userinfo.mapper.UserMapper;
import com.foodservice.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO addNewUser(UserDTO userDTO) {
        User savedUser = userRepository.save(UserMapper.INSTANCE.mapUserDTOtoUser(userDTO));
        return UserMapper.INSTANCE.mapUsertoUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Integer id) {
        Optional<User> fetchedUser = userRepository.findById(id);
        if (fetchedUser.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUsertoUserDTO(fetchedUser.get()), HttpStatus.OK);

        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public List<UserDTO> findAllUsers(UserDTO userDTO) {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserMapper.INSTANCE::mapUsertoUserDTO).toList();
    }
}
