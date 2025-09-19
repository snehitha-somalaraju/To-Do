package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Show all tasks
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "index";
    }

    // Create new task form
    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    // Save new task
    @PostMapping
    public String saveTask(@ModelAttribute Task task) {
        service.save(task);
        return "redirect:/task/";
    }

    // Edit task form
    @GetMapping("/edit/{id}")
public String editTask(@PathVariable Long id, Model model) {
    return service.findById(id)
            .map(task -> {
                model.addAttribute("task", task);
                return "edit-task";
            })
            .orElse("redirect:/task/?error=TaskNotFound");
}

@PostMapping("/update/{id}")
public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
    return service.findById(id).map(existing -> {
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setCompleted(task.isCompleted());
        service.save(existing);
        return "redirect:/task/";
    }).orElse("redirect:/task/?error=TaskNotFound");
}

@PostMapping("/delete/{id}")
public String deleteTask(@PathVariable Long id) {
    if (!service.delete(id)) {
        return "redirect:/task/?error=DeleteFailed";
    }
    return "redirect:/task/";
}

}
