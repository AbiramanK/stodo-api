package com.sapp.stodo.mapper;

import com.sapp.stodo.dto.UserTodoMappingDto;
import com.sapp.stodo.entity.UserTodoMapping;

public class UserTodoMappingMapper {
    public static UserTodoMappingDto mapToUserMappingDto(UserTodoMapping userTodoMapping) {
        return new UserTodoMappingDto(
                userTodoMapping.getId(),
                userTodoMapping.getUser(),
                userTodoMapping.getTodo()
        );
    }

    public static UserTodoMapping mapToUserMapping(UserTodoMappingDto userTodoMappingDto) {
        return new UserTodoMapping(
                userTodoMappingDto.getId(),
                userTodoMappingDto.getUser(),
                userTodoMappingDto.getTodo()
        );
    }
}
