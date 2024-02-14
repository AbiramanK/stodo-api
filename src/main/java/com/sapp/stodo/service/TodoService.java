package com.sapp.stodo.service;

import com.sapp.stodo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto createTodo(TodoDto todoDto);

    TodoDto getTodoById(Long todoId);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(Long todoId, TodoDto todoDto);

    void deleteTodo(Long todoId);
}
