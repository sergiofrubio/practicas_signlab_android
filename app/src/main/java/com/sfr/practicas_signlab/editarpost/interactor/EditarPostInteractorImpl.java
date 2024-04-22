package com.sfr.practicas_signlab.editarpost.interactor;

import android.util.Log;

import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.wsApi.WsApi;
import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarPostInteractorImpl implements EditarPostInteractor{
    @Inject
    WsApi wsApi;

    @Inject
    public EditarPostInteractorImpl(){}


    @Override
    public void onSetDataToApi(int postId, int id,  String title, String body, int userId, onSetDataToApiCallbacks callBacks, OnErrorServer errorServer) {
        Call<Post> call = wsApi.updatePost(postId, id, title, body, userId);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    // La solicitud fue exitosa
                    // Puedes manejar la respuesta aquí si es necesario
                    Log.i("m", ""+response.body().getTitle());
                    callBacks.onSetDataToApiSuccessCallbacks(response.body());

                } else {
                    // La solicitud no fue exitosa
                    // Maneja el error aquí
                    callBacks.onErrorCallBacks(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                // Se produjo un error en la solicitud
                // Maneja el error aquí
                errorServer.errorServerMessage(t.getLocalizedMessage());
            }
        });

    }
}
