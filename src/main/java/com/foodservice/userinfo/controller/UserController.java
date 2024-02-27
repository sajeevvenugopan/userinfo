package com.foodservice.userinfo.controller;

import com.foodservice.userinfo.dto.UserDTO;
import com.foodservice.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.addNewUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/fetchuserbyid/{id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer id) {
        return userService.fetchUserById(id);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<UserDTO>> getAllUsers(UserDTO userDTO) {
        List<UserDTO> allUsers = userService.findAllUsers(userDTO);
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
}
