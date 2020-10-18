package com.a.crud_web_api_kotlin.Repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.a.crud_web_api_kotlin.ConsumoAPI.CRUD
import com.a.crud_web_api_kotlin.ConsumoAPI.OkHttpListagem.ConsumoLista
import com.a.crud_web_api_kotlin.model.model

class Repository : LifecycleOwner {


    @RequiresApi(Build.VERSION_CODES.N)
    fun ListAll():MutableLiveData<ArrayList<model>> {
        var listaUsuarios = ArrayList<model>()
        ConsumoLista().Lista_OkHttp().observeForever{
            listaUsuarios.addAll(it)

        }
        var LiveData = MutableLiveData<ArrayList<model>>()
        LiveData.postValue(listaUsuarios)
        return LiveData
    }

    suspend fun addUser(model: model){
        CRUD().Insert_OkHttp(model)
    }

    suspend fun updateUser(model:model){
        CRUD().Update_OkHttp(model)
    }

    suspend fun deleteUser(model:model){
        CRUD().Excluir_OkHttp(model)
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }


}