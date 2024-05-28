package com.sapp.stodo.repository;

import com.sapp.stodo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
