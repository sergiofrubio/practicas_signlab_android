package com.sfr.practicas_signlab.detalleusuario.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.databinding.ItemPhotoBinding;
import com.sfr.practicas_signlab.databinding.ItemPostBinding;
import com.sfr.practicas_signlab.usuarios.adapters.UsuariosAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private ArrayList<Post> posts;
    private Post post;
    private OnItemClickListener itemClickListener;
    private OnImageClickListener imageClickListener;

    public interface OnItemClickListener {
        void onItemClick(Post post);
    }

    public interface OnImageClickListener {
        void onImageClick(Post post);
    }


    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public void setOnImageClickListener(OnImageClickListener listener) {
        this.imageClickListener = listener;
    }

    public PostsAdapter(ArrayList<Post> posts, OnItemClickListener onItemClickListener, OnImageClickListener onImageClickListener) {
        this.posts = posts;
        this.imageClickListener = onImageClickListener;
        this.itemClickListener = onItemClickListener;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(post);
                }
            }
        });

        holder.binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageClickListener != null) {
                    imageClickListener.onImageClick(post);
                }
            }
        });
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
