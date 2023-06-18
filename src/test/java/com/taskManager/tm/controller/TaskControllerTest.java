package com.taskManager.tm.controller;

import com.taskManager.tm.service.TaskService;
import com.taskManager.tm.model.Task;
import com.taskManager.tm.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TaskControllerTest {

    private TaskController taskController;

    /**
     * test,
     * we se up a mock TaskService with some sample tatks.
     * we then initialize the taskController with the mock TaskService.
     * The testGetTasks method calls getTasks method of TaskController and verifies the returned list of tasks.
     *
     */
    @BeforeEach
    public void setUp() {
        // create a mock TaskService
        TaskService taskService = new TaskService();

        Task task1 = TaskService.addTask(new Task());
        Task task2 = TaskService.addTask(new Task());
        task1.setTitle("name1");
        task2.setTitle("name2");

        //init the TaskController with the mock TaskService
        taskController = new TaskController(taskService);

    }

    @Test
    public void testGetTasks() {
        // Invoke the getTasks method and retrieve the list of tasks
        List<Task> tasks = taskController.getTasks();

        // Check if the returned list is not null and contains the expected number of teasks
        Assertions.assertNotNull(tasks);
        Assertions.assertEquals(2, tasks.size());
    }

        //further assertions and validation of individual tasks if needed

        // You can further validate the individual tasks if needed
        // Assertions.assertEquals("Task 1", tasks.get(0).getTitle());
        // Assertions.assertEquals("Description 1", tasks.get(0).getDescription());
        // Assertions.assertEquals("Task 2", tasks.get(1).getTitle());
        // Assertions.assertEquals("Description 2", tasks.get(1).getDescription());    }
}
