package com.taskManager.tm.controller;

import com.taskManager.tm.service.TaskService;
import com.taskManager.tm.model.Task;
import com.taskManager.tm.service.TaskService;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


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
        assertNotNull(tasks);
        assertEquals(2, tasks.size());

        //further assertions and validation of individual tasks if needed

        // You can further validate the individual tasks if needed
        // Assertions.assertEquals("Task 1", tasks.get(0).getTitle());
        // Assertions.assertEquals("Description 1", tasks.get(0).getDescription());
        // Assertions.assertEquals("Task 2", tasks.get(1).getTitle());
        // Assertions.assertEquals("Description 2", tasks.get(1).getDescription());
    }


    //TEST POST ENPOINT

    @Test
    public void testCreatetask(){
        Task task = new Task();
        ResponseEntity<Task> response = taskController.createTask(task);
        task.setTitle("Test Task");
        task.setDescription("This is a test task");

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("pending", response.getBody().getStatus());
        assertNotNull(response.getBody().getId());
        assertEquals("Test Task", response.getBody().getTitle());
        assertEquals("This is a test task", response.getBody().getDescription());

    }

//    @Test
//    public void testCreateTaskWithInvalidInput() {
//        Task task = new Task(UUID.randomUUID(),"", "", "");
//
//        ResponseEntity<Task> response = taskController.createTask(task);
//
//        // check if status code is BAD_REQUEST or your chosen error
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//    }

//    ADD SOME VALIDATION TO OUR CREATE TASKF OR EMPTY TASK OR BAD INPUT



}
