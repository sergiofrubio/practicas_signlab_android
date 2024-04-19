package com.sfr.practicas_signlab.detallepost.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.practicas_signlab.api.Models.Comment;
import com.sfr.practicas_signlab.databinding.ItemCommentBinding;
import com.sfr.practicas_signlab.databinding.ItemPostBinding;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    private ArrayList<Comment> comments;

    public CommentsAdapter(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCommentBinding binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CommentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);
        // Configurar vistas con datos de usuario
        holder.bind(comment);
    }

    @Override
    public int getItemCount() {
        return comments != null ? comments.size() : 0;
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        ItemCommentBinding binding;

        public CommentViewHolder(@NonNull ItemCommentBinding itemCommentBinding) {
            super(itemCommentBinding.getRoot());
            binding = itemCommentBinding;
        }

        public void bind(Comment comment) {
            binding.textViewAutor.setText("Autor: "+comment.getName());
            binding.textViewNombre.setText("Nombre: "+comment.getName());
            binding.textViewComment.setText("Comentario: "+comment.getBody());
            // Puedes configurar más vistas aquí
        }
    }
}
