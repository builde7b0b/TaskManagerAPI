package com.taskManager.tm.service;

import com.taskManager.tm.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * TaskService class provides teh service for managing tasks in the task management system.
 * It is responsible for adding tasks to the system and retrieving thte list of existing tasks.
 */
@Service
public class TaskService {

    private static final List<Task> tasks = new ArrayList<>(); //List to store the tasks

    /**
     * Get the list of taks
     * @return the List of tasks
     */

    public List<Task> getTasks() {
        return tasks;

    }

    /**
     * Add a new task to the system.
     * @param task The task to be added.
     * @return The added task.
     */
    public static Task addTask(Task task) {
        tasks.add(task);
        return task;

    }
}
