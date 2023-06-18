package com.taskManager.tm.controller;

import com.taskManager.tm.model.Task;
import com.taskManager.tm.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TaskController class handles the HTTP requests related to the tasks in teh task management system.
 * it interacts with the TaskService to perform the necessary operation.
 */
@RestController
public class TaskController {

    private final TaskService taskService;

    /**
     * Constructs a new TaskController with the given TaskService.
     * @param taskService the TaskService used to perform task-related operations.
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
}
