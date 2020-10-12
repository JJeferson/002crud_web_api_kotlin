package com.a.crud_web_api_kotlin.Repository

import com.a.crud_web_api_kotlin.ConsumoAPI.CRUD
import com.a.crud_web_api_kotlin.model.model

class Repository {




    suspend fun addUser(model: model){
        CRUD().Insert_OkHttp(model)
    }

    suspend fun updateUser(model:model){
        CRUD().Update_OkHttp(model)
    }

    suspend fun deleteUser(model:model){
        CRUD().Excluir_OkHttp(model)
    }


}