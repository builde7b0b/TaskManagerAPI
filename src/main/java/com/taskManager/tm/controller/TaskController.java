package com.taskManager.tm.controller;

import com.taskManager.tm.model.Task;
import com.taskManager.tm.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TaskController class handles the HTTP requests related to the tasks in teh task management system.
 * it interacts with the TaskService to perform the necessary operation.
 */
@RestController
@RequestMapping("/api")
public class TaskController {
// http://localhost:8080/api
    //http://localhost:8080/api/tasks

    private final TaskService taskService;

    private List<Task> tasks = new ArrayList<>();

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


    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        task.getId().toString();
        task.setStatus("pending");
        tasks.add(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
