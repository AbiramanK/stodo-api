package com.sapp.stodo.controller;

import com.sapp.stodo.dto.LoginDto;
import com.sapp.stodo.dto.UserDto;
import com.sapp.stodo.service.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.ValidatorFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private UserService userService;
    private ValidatorFactory validatorFactory;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        Set<ConstraintViolation<LoginDto>> violations = validatorFactory.getValidator().validate(loginDto);
        if (!violations.isEmpty()){
            throw new ValidationException(String.valueOf(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())));
        }
        return ResponseEntity.ok("Welcome");
//                UserDto userDto = userService.findUserByEmail(loginDto.getEmail());
//        return ResponseEntity.ok(userDto);
    }
}
