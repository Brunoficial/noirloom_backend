package com.noirloom.noirloom.mappers;

import com.noirloom.noirloom.DTOs.UserDto;
import com.noirloom.noirloom.models.UserModel;

public class UserMapper {
    public static UserDto mapToUserDTO(UserModel user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getNationality(),
                user.getGender(),
                user.getRole()
        );
    }

    public static UserModel mapToUserModel(UserDto userDto) {
        return new UserModel(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getNationality(),
                userDto.getGender(),
                userDto.getRole()
        );
    }
}
