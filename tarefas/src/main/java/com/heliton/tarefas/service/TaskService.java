package com.heliton.tarefas.service;

import org.springframework.stereotype.Service;

import com.heliton.tarefas.models.Task;
import com.heliton.tarefas.models.TaskStatus;
import com.heliton.tarefas.models.WeatherData;
import com.heliton.tarefas.repository.TaskRepository;
import com.heliton.tarefas.util.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final WeatherService weatherService;

    public TaskService(TaskRepository taskRepository, WeatherService weatherService) {
        this.taskRepository = taskRepository;
        this.weatherService = weatherService;
    }

    public Task createTask(Task task) {
        task.setStatus(TaskStatus.PENDING);
        task.setCreationDate(LocalDate.now());
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        Task task = getTask(taskId);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        return taskRepository.save(task);
    }

    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o ID: " + taskId));
    }

    public void deleteTask(Long taskId) {
        Task task = getTask(taskId);
        taskRepository.delete(task);
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        
        for (Task task : tasks) {
            WeatherData weatherData = weatherService.getWeatherData(task.getLatitude(), task.getLongitude());
            task.setWeatherData(weatherData);
        }
        
        return tasks;
    }

}
