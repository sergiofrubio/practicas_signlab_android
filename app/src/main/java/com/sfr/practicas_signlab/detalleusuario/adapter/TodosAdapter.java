package com.sfr.practicas_signlab.detalleusuario.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfr.practicas_signlab.api.Models.Todo;
import com.sfr.practicas_signlab.databinding.ItemTodoBinding;
import java.util.ArrayList;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodoViewHolder> {
    private ArrayList<Todo> todos;

    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTodoBinding binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TodoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        // Configurar vistas con datos de usuario
        holder.bind(todo);
    }

    @Override
    public int getItemCount() {
        return todos != null ? todos.size() : 0;
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        ItemTodoBinding binding;

        public TodoViewHolder(@NonNull ItemTodoBinding itemTodoBinding) {
            super(itemTodoBinding.getRoot());
            binding = itemTodoBinding;
        }

        public void bind(Todo todo) {
            binding.textViewTitle.setText(todo.getTitle());
            binding.textViewCompleted.setText(todo.isCompleted());
            // Puedes configurar más vistas aquí
        }
    }
}
