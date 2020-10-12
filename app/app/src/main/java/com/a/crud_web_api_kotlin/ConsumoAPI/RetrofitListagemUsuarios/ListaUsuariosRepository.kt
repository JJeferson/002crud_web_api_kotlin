package com.a.crud_web_api_kotlin.ConsumoAPI.RetrofitListagemUsuarios

import android.os.Build
import android.os.StrictMode
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.a.crud_web_api_kotlin.model.model
import com.a.crud_web_api_kotlin.model.modelListaUsuarios
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class ListaUsuariosRepository {


    lateinit var UsersList : MutableLiveData<List<model>>
    private val TAG = ListaUsuariosRepository::class.java!!.getSimpleName()
    private val apiRequest: endpoints



    init {

        apiRequest = RetrofitClientListaUsuarios.getRetrofitInstance().create(endpoints::class.java)
    }
    fun getUsersList() : LiveData<List<model>>{

        UsersList = MutableLiveData()




        apiRequest.getUsers().enqueue(object : Callback<modelListaUsuarios>{
            override fun onResponse(call: Call<modelListaUsuarios>, response: Response<modelListaUsuarios>) {
                Log.d(TAG,response.code().toString())

               UsersList.value = response.body()!!.ListaDeUsuarios.toMutableList()

            }

            override fun onFailure(call: Call<modelListaUsuarios>, t: Throwable) {

            }
        })
        return UsersList
    }


}

