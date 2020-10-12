package com.a.crud_web_api_kotlin.ConsumoAPI.RetrofitListagemUsuarios

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.a.crud_web_api_kotlin.model.model

class ViewModelListaUsers(application: Application): AndroidViewModel(application), LifecycleOwner {



    val  Repository: ListaUsuariosRepository
    val  ResponseLiveData: LiveData<List<model>>
    init {

        Repository = ListaUsuariosRepository()
        this.ResponseLiveData =
              Repository.getUsersList()

    }

    fun getUsersData(): LiveData<List<model>> {
        return ResponseLiveData
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }


}