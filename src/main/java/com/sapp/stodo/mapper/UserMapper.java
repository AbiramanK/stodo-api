package com.sapp.stodo.mapper;

import com.sapp.stodo.dto.UserDto;
import com.sapp.stodo.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
