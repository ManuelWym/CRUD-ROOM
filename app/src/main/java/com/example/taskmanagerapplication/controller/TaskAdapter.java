package com.example.taskmanagerapplication.controller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmanagerapplication.R;
import com.example.taskmanagerapplication.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    public interface OnTaskDeleteListener {
        void onDeleteTask(Task task);
    }

    private OnTaskDeleteListener listener;

    public void setOnTaskDeleteListener(OnTaskDeleteListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);

        holder.textTaskTitle.setText(task.getTaskTitle());

        // Edita cuando se hace click
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), TaskFormActivity.class);
            intent.putExtra("task_id", task.getId());
            v.getContext().startActivity(intent);
        });

        // Elimina al hacer un click largo
        holder.itemView.setOnLongClickListener(v -> {
            if (listener != null) listener.onDeleteTask(task);
            return true;
        });
    }



    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView textTaskTitle;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textTaskTitle = itemView.findViewById(R.id.textTaskTitle);
        }
    }

}
