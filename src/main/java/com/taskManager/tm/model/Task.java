package com.taskManager.tm.model;

import java.util.UUID;

// create new java class
//this will represent a task in our system


/**
 * Task calss representss a task in our task management ssytem,
 * it encapsulates the information related to a task, including its ID, title, description and status.
 */
public class Task {

    // init variables for task parameters
    private final UUID id; // The unique id for the task
    private String title; // the title of the taksk
    private String description; // the description of the task
    private String status; // the status of the task

    /**
     * Constructor for the Task class
     * initializes the task with a unique ID and sets the inital status to "pending".
     */
    public Task() {
        this.id = UUID.randomUUID();
        this.status = "pending";
    }

    /**
     * Get the ID of the task
     * @return The unique ID of the task
     */
    public UUID getId() {
        return id;
    }

    /**
     * Get the title of the task.
     * @return The title of the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the task,
     * @param title The title of the task to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the description of the task.
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Description of the task
     * @param description The description of the task to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the status of the task
     * @return the current status of the Task
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the task
     * @param status the status of the task to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }


    //getters and setters

}
