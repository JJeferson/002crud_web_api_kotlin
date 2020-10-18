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



    @RequiresApi(Build.VERSION_CODES.N)
     fun ListAll():MutableLiveData<ArrayList<model>> {
        var listaUsuarios = ArrayList<model>()
        repository.ListAll().observeForever{
            listaUsuarios.addAll(it)

        }
        var LiveData = MutableLiveData<ArrayList<model>>()
        LiveData.postValue(listaUsuarios)
        return LiveData
    }


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
