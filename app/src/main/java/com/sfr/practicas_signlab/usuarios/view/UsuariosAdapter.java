package com.sfr.practicas_signlab.usuarios.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.databinding.ItemUserBinding;

import java.util.ArrayList;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuarioViewHolder> {
    private ArrayList<User> users;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UsuarioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        User user = users.get(position);
        // Configurar vistas con datos de usuario
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public UsuarioViewHolder(@NonNull ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            binding = itemUserBinding;
        }

        public void bind(User user) {
            binding.textViewName.setText(user.getName());
            binding.textViewUsername.setText(String.valueOf(user.getUsername()));
            // Puedes configurar más vistas aquí
        }
    }
}
