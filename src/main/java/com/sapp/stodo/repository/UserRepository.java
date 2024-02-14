package com.sapp.stodo.repository;

import com.sapp.stodo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
