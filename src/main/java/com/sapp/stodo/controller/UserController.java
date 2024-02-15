package com.sapp.stodo.controller;

import com.sapp.stodo.dto.UserDto;
import com.sapp.stodo.dto.UserTodoMappingDto;
import com.sapp.stodo.service.UserService;
import com.sapp.stodo.service.UserTodoMappingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private UserTodoMappingService userTodoMappingService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto user) {
        UserDto updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/{id}/todo")
    public ResponseEntity<List<UserTodoMappingDto>> getUserTodos(@PathVariable("id") Long userId) {
        List<UserTodoMappingDto> todos = userTodoMappingService.getUserTodos(userId);
        return ResponseEntity.ok(todos);
    }
}
