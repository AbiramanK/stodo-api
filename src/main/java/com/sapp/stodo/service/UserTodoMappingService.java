package com.sapp.stodo.service;

import com.sapp.stodo.dto.UserTodoMappingDto;

import java.util.List;

public interface UserTodoMappingService {
    List<UserTodoMappingDto> getUserTodos(Long userId);
}
