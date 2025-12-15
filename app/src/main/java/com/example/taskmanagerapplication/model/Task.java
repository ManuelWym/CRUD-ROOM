package com.example.taskmanagerapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "task_title")
    private String taskTitle;

    @ColumnInfo(name = "task_description")
    private String taskDescription;

    @ColumnInfo(name = "created_at")
    private String createdAt;

    @ColumnInfo(name = "is_completed")
    private boolean isCompleted;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTaskTitle() { return taskTitle; }
    public void setTaskTitle(String taskTitle) { this.taskTitle = taskTitle; }

    public String getTaskDescription() { return taskDescription; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    public String getTitle() {
        return taskTitle;
    }
}
