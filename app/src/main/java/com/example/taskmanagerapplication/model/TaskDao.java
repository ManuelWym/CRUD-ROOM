package com.example.taskmanagerapplication.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Update
    void updateTask(Task task);

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    Task getTaskById(int taskId);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * FROM tasks ORDER BY created_at DESC")
    List<Task> getAllTasks();


}
