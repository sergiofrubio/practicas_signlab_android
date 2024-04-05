package com.sfr.practicas_signlab.albunes.view;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.api.Models.User;

import java.util.ArrayList;

public interface AlbunesFragment {
    void showAlbums(ArrayList<Album> albums);
    void showUser(ArrayList<User> users);
}
