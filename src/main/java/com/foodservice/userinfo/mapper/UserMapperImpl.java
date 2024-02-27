package com.foodservice.userinfo.mapper;

import com.foodservice.userinfo.dto.UserDTO;
import com.foodservice.userinfo.entity.User;

public class UserMapperImpl implements UserMapper{
    @Override
    public User mapUserDTOtoUser(UserDTO userDTO) {
        if(userDTO == null){
            return null;
        }
        else {
            User user = new User();
            user.setUserId(userDTO.getUserId());
            user.setUserName(userDTO.getUserName());
            user.setUserPassword(userDTO.getUserPassword());
            user.setAddress(userDTO.getAddress());
            user.setCity(userDTO.getCity());

            return user;
        }
    }

    @Override
    public UserDTO mapUsertoUserDTO(User user) {
        if(user == null) {
            return null;
        }
        else {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setUserName(user.getUserName());
            userDTO.setUserPassword(user.getUserPassword());
            userDTO.setAddress(user.getAddress());
            userDTO.setCity(user.getCity());

            return userDTO;
        }
    }
}
