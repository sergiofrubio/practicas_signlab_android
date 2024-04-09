package com.sfr.practicas_signlab.albunes.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.databinding.ItemAlbumBinding;
import java.util.ArrayList;

public class AlbunesAdapter extends RecyclerView.Adapter<AlbunesAdapter.AlbumViewHolder> implements Filterable {
    private ArrayList<Album> albums; // Lista con todos los albunes
    private ArrayList<Album> albumsFiltered; // Lista filtrada para mostrar los resultados
    private static ArrayList<User> users; // Lista de usuarios

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
        this.albumsFiltered = albums;
    }

    public void setUsers(ArrayList<User> users){
        this.users=users;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlbumBinding binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.bind(albumsFiltered.get(position));
    }

    @Override
    public int getItemCount() {
        return albumsFiltered != null ? albumsFiltered.size() : 0;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    // Si no hay restricciones, mostrar la lista original
                    results.values = albums;
                    results.count = albums.size();
                } else {
                    ArrayList<Album> filteredList = new ArrayList<>();
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    for (Album album : albums) {
                        if (album.getTitle().toLowerCase().contains(filterPattern)) {
                            filteredList.add(album);
                        }
                    }

                    results.values = filteredList;
                    results.count = filteredList.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                albumsFiltered = (ArrayList<Album>) results.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        ItemAlbumBinding binding;

        public AlbumViewHolder(@NonNull ItemAlbumBinding itemAlbumBinding) {
            super(itemAlbumBinding.getRoot());
            binding = itemAlbumBinding;
        }

        public void bind(Album album) {
            binding.textViewId.setText(album.getUserId());
            binding.textViewTitle.setText(album.getTitle());

            for (User user : users) {
                if (user.getId() == Integer.parseInt(album.getUserId())) {
                    binding.textViewId.setText(user.getName());
                    break;
                }
            }
        }
    }
}