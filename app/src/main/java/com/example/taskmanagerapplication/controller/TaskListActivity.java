package com.example.taskmanagerapplication.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.taskmanagerapplication.R;
import com.example.taskmanagerapplication.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    private TaskController controller;
    private RecyclerView recyclerTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        recyclerTasks = findViewById(R.id.recyclerTasks);
        FloatingActionButton fabAddTask = findViewById(R.id.fabAddTask);

        fabAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(this, TaskFormActivity.class);
            startActivity(intent);
        });

        controller = new TaskController(this);
    }

    private void loadTasks() {
        List<Task> tasks = controller.getAllTasks();

        TaskAdapter adapter = new TaskAdapter(tasks);
        recyclerTasks.setAdapter(adapter);

        recyclerTasks.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnTaskDeleteListener(task -> {
            controller.deleteTask(task);
            Toast.makeText(this, "Tarea eliminada", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTasks(); // Se ejecuta en tiempo real
    }

}
