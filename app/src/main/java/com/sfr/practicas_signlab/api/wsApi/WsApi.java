package com.sfr.practicas_signlab.api.wsApi;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.utils.Constantes;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WsApi {
    @GET(Constantes.GET_USERS)
    Call<List<User>> getAllUsers();

    @GET(Constantes.GET_ALBUMS)
    Call<List<Album>> getAllAlbums();

    @GET(Constantes.GET_PHOTOS)
    Call<List<Photo>> getAllPhotos();
}
