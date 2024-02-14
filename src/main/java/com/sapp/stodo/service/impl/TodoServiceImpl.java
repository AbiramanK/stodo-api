package com.sapp.stodo.service.impl;

import com.sapp.stodo.dto.TodoDto;
import com.sapp.stodo.entity.Todo;
import com.sapp.stodo.exception.ResourceNotFoundException;
import com.sapp.stodo.mapper.TodoMapper;
import com.sapp.stodo.repository.TodoRepository;
import com.sapp.stodo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.mapToTodo(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(savedTodo);
    }

    @Override
    public TodoDto getTodoById(Long todoId) {
        Todo todo = findTodoById(todoId);
        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoMapper::mapToTodoDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long todoId, TodoDto todoDto) {
        Todo todo = findTodoById(todoId);

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());

        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        findTodoById(todoId);
        todoRepository.deleteById(todoId);

    }

    public Todo findTodoById(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Todo is not exists with given id: " + todoId));
    }

}
