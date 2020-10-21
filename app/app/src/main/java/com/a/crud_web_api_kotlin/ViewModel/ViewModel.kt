package com.a.crud_web_api_kotlin.ViewModel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.a.crud_web_api_kotlin.ConsumoAPI.OkHttpListagem.ConsumoLista
import com.a.crud_web_api_kotlin.Repository.Repository
import com.a.crud_web_api_kotlin.model.model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewModel(application: Application): AndroidViewModel(application), LifecycleOwner {

    private var repository: Repository


    init {
        repository = Repository()
    }//fim do init

    fun addUser(model:model){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(model)
        }
    }

    fun updateUser(model:model){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(model)
        }
    }

    fun deleteUser(model:model){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(model)
        }
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }


}
