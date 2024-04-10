package com.sfr.practicas_signlab.usuarios.adapters;

import static androidx.core.content.ContentProviderCompat.requireContext;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
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
        holder.bind(user);

/*        // Configura el OnClickListener para el elemento
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén el usuario correspondiente al elemento clicado
                User clickedUser = users.get(position);
                // Inicia la actividad DetalleUsuarioActivity con el usuario correspondiente
                Intent intent = new Intent(requireContext(this), DetalleUsuarioActivity.class);
                intent.putExtra("user", clickedUser); // Puedes pasar el usuario a la actividad
                context.startActivity(intent);
            }
        });*/
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
            binding.textViewUsername.setText(user.getUsername());
            binding.textViewEmail.setText(user.getEmail());

        }
    }
}
