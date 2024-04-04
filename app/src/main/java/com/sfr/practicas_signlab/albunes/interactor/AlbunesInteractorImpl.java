package com.sfr.practicas_signlab.albunes.interactor;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.api.wsApi.WsApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbunesInteractorImpl implements AlbunesInteractor {

    @Inject
    WsApi wsApi;

    @Inject
    public AlbunesInteractorImpl(){}


    @Override
    public void getAlbumsFromApi(OnGetAlbumsCallBacks callBacks, OnErrorServer errorServer) {
        wsApi.getAllAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if(response.isSuccessful()){
                    callBacks.onSuccessCallBacks(new ArrayList<Album>(response.body()));
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }
}

