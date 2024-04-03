package com.sfr.practicas_signlab.di.appModule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sfr.practicas_signlab.api.wsApi.WsApi;
import com.sfr.practicas_signlab.utils.Constantes;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ConnectionModule {

    private String urlBase;
    public ConnectionModule() {
        this.urlBase = Constantes.SERVER_URL;
    }

    public ConnectionModule(String urlBase) {
        if(!urlBase.isEmpty()){
            this.urlBase=urlBase;
        }else{
            this.urlBase= Constantes.SERVER_URL;
        }
    }

    @Provides
    @Singleton
    public WsApi providesApi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(this.urlBase)
                .client(okHttpClient)
                .build();

        return retrofit.create(WsApi.class);
    }

}
