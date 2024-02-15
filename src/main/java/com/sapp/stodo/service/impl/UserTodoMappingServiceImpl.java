package com.sapp.stodo.service.impl;

import com.sapp.stodo.dto.UserTodoMappingDto;
import com.sapp.stodo.entity.UserTodoMapping;
import com.sapp.stodo.mapper.UserTodoMappingMapper;
import com.sapp.stodo.repository.UserTodoMappingRepository;
import com.sapp.stodo.service.UserTodoMappingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserTodoMappingServiceImpl implements UserTodoMappingService {

    private UserTodoMappingRepository userTodoMappingRepository;

    @Override
    public List<UserTodoMappingDto> getUserTodos(Long userId) {
        List<UserTodoMapping> todos = userTodoMappingRepository.findByUserId(userId);
        return todos.stream().map(UserTodoMappingMapper::mapToUserMappingDto).collect(Collectors.toList());
    }
}
