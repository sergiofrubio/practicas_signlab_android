package com.sfr.practicas_signlab.crearpost.interactor;

import android.util.Log;

import com.sfr.practicas_signlab.api.Models.Comment;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.wsApi.WsApi;
import com.sfr.practicas_signlab.detallepost.interactor.DetallePostInteractor;
import com.sfr.practicas_signlab.editarpost.interactor.EditarPostInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrearPostInteractorImpl implements CrearPostInteractor {
    @Inject
    WsApi wsApi;
    @Inject
    public CrearPostInteractorImpl(){}

    @Override
    public void onSetDataToApi(int userId, String title, String body, CrearPostInteractor.onSetDataToApiCallbacks callBacks, CrearPostInteractor.OnErrorServer errorServer) {
        Call<Post> call = wsApi.createPost(userId, title, body);
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
