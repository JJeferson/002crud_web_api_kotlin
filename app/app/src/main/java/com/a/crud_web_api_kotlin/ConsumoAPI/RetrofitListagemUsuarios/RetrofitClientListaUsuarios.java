package com.a.crud_web_api_kotlin.ConsumoAPI.RetrofitListagemUsuarios;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientListaUsuarios {


    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.0.104:3000/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
