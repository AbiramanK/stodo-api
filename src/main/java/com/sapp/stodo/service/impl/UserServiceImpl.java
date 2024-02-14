package com.sapp.stodo.service.impl;

import com.sapp.stodo.dto.UserDto;
import com.sapp.stodo.entity.User;
import com.sapp.stodo.exception.ResourceNotFoundException;
import com.sapp.stodo.mapper.UserMapper;
import com.sapp.stodo.repository.UserRepository;
import com.sapp.stodo.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(UserMapper.mapToUser(userDto));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = findUserById(userId);
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = findUserById(userId);

        user.setName(userDto.getName());

        User updatedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }

    public User findUserById(Long userId) {
      return  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id: " + userId));
    }
}
