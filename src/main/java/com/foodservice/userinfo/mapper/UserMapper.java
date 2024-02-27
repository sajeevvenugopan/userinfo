package com.foodservice.userinfo.mapper;

import com.foodservice.userinfo.dto.UserDTO;
import com.foodservice.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOtoUser(UserDTO userDTO);
    UserDTO mapUsertoUserDTO(User user);
}
