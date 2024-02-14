package com.sapp.stodo.mapper;

import com.sapp.stodo.dto.TodoDto;
import com.sapp.stodo.entity.Todo;

public class TodoMapper {
    public static TodoDto mapToTodoDto(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription()
        );
    }

    public static Todo mapToTodo(TodoDto todoDto) {
        return  new Todo(
                todoDto.getId(),
                todoDto.getTitle(),
                todoDto.getDescription()
        );
    }
}
