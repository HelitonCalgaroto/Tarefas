package com.heliton.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heliton.tarefas.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}