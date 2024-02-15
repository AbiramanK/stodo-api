package com.sapp.stodo.dto;

import com.sapp.stodo.entity.Todo;
import com.sapp.stodo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTodoMappingDto {
    private Long id;
    private User user;
    private Todo todo;
}
