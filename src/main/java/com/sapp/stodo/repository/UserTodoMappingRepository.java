package com.sapp.stodo.repository;

import com.sapp.stodo.entity.UserTodoMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTodoMappingRepository extends JpaRepository<UserTodoMapping, Long> {
    List<UserTodoMapping> findByUserId(Long userId);
}
