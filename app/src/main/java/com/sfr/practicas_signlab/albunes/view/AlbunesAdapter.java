package com.sfr.practicas_signlab.albunes.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.databinding.ItemAlbumBinding;

import java.util.ArrayList;

public class AlbunesAdapter extends RecyclerView.Adapter<AlbunesAdapter.AlbumViewHolder> {
    private ArrayList<Album> albums;

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlbumBinding binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albums.get(position);
        // Configurar vistas con datos de usuario
        holder.bind(album);
    }

    @Override
    public int getItemCount() {
        return albums != null ? albums.size() : 0;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        ItemAlbumBinding binding;

        public AlbumViewHolder(@NonNull ItemAlbumBinding itemAlbumBinding) {
            super(itemAlbumBinding.getRoot());
            binding = itemAlbumBinding;
        }

        public void bind(Album album) {
            binding.textViewId.setText(album.getId());
            binding.textViewAlbumId.setText(album.getUserId());
            binding.textViewTitle.setText(album.getTitle());
            // Puedes configurar más vistas aquí
        }
    }
}
