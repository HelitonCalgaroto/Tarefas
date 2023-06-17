package com.heliton.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heliton.tarefas.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}