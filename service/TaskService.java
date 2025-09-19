package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return repository.findById(id); // return Optional, not null
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false; // if not found, nothing deleted
    }
}
