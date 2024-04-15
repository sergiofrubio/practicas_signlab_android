package com.sfr.practicas_signlab.detalleusuario.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.databinding.ItemPhotoBinding;
import com.sfr.practicas_signlab.databinding.ItemPostBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private ArrayList<Post> posts;

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        // Configurar vistas con datos de usuario
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ItemPostBinding binding;

        public PostViewHolder(@NonNull ItemPostBinding itemPostBinding) {
            super(itemPostBinding.getRoot());
            binding = itemPostBinding;
        }

        public void bind(Post post) {
            binding.textViewBody.setText(post.getTitle());
            // Puedes configurar más vistas aquí
        }
    }
}
