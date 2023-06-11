package com.heliton.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heliton.tarefas.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}