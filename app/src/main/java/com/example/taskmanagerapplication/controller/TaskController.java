package com.example.taskmanagerapplication.controller;

import android.content.Context;

import androidx.room.Room;

import com.example.taskmanagerapplication.model.AppDatabase;
import com.example.taskmanagerapplication.model.Task;

import java.util.List;

public class TaskController {

    private final AppDatabase db;

    public TaskController(Context context) {
        db = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "task_manager_db"
        ).allowMainThreadQueries().build();
    }
    public void deleteTask(Task task) {
        db.taskDao().deleteTask(task);
    }

    public List<Task> getAllTasks() {
        return db.taskDao().getAllTasks();
    }
}