package com.sfr.practicas_signlab.api.wsApi;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.api.Models.Comment;
import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.Todo;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.utils.Constantes;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WsApi {
    @GET(Constantes.GET_USERS)
    Call<List<User>> getAllUsers();

    @GET(Constantes.GET_ALBUMS)
    Call<List<Album>> getAllAlbums();

    @GET(Constantes.GET_PHOTOS)
    Call<List<Photo>> getAllPhotos();

    @GET(Constantes.GET_POSTS)
    Call<List<Post>> getUserPosts(@Query("userId") int userId);

    @GET(Constantes.GET_TODOS)
    Call<List<Todo>> getUserTodos(@Query("userId") int userId);

    @GET(Constantes.GET_COMMENTS)
    Call<List<Comment>> getPostComments(@Query("postId") int postId);

    @FormUrlEncoded
    @PUT(Constantes.UPDATE_POST)
    Call<Post> updatePost(
            @Path("id") int postId,
            @Field("id") int id,
            @Field("title") String title,
            @Field("body") String body,
            @Field("userId") int userId
    );

    @FormUrlEncoded
    @POST(Constantes.CREATE_POST)
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body
    );

}
