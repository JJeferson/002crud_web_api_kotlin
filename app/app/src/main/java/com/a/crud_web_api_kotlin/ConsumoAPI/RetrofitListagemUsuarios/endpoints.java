package com.a.crud_web_api_kotlin.ConsumoAPI.RetrofitListagemUsuarios;

import com.a.crud_web_api_kotlin.model.model;
import com.a.crud_web_api_kotlin.model.modelListaUsuarios;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;


    public interface endpoints {

      ///  @Headers({"chave_unica","teste"})
        @GET("usuarios" )
        Call<modelListaUsuarios> getUsers();

    }


