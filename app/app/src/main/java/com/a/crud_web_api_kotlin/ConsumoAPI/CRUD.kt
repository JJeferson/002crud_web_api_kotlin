package com.a.crud_web_api_kotlin.ConsumoAPI

import android.os.Build
import android.os.StrictMode
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.a.crud_web_api_kotlin.adapter.adapter
import com.a.crud_web_api_kotlin.model.model
import kotlinx.android.synthetic.main.insert_actiondialog.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.util.*


class CRUD()  {

    //--------------------------------------------------
    //Inicializando componentes para acessar API
    var EnderecoWeb = "http://192.168.0.104"
    var Porta = ":3000"
    var Rota = "/usuarios"
    var Metodo = ""
    var TituloHeader01 = "chave_unica"
    var ValorHeader01  = "teste"

    //----------------------------------------------------
    fun Excluir_OkHttp(model:model){
        Metodo = "DELETE"
        var policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val recebeDados = model

        var formBody: RequestBody = FormBody.Builder()
            .add("id_usuario",recebeDados.id_usuario.toString())
            .build()


        var client = OkHttpClient().newBuilder()
            .build()


        var request: Request = Request.Builder()
            .url(EnderecoWeb+Porta+Rota)
            .method(Metodo,formBody)
            .addHeader(TituloHeader01, ValorHeader01)
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}


            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {

                try {

                    var data = response.body()?.string()



                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        })
    } // final do Excluir
    //----------------------------------------------------

      fun Update_OkHttp(model:model){
          Metodo = "PATCH"
          var policy =
              StrictMode.ThreadPolicy.Builder().permitAll().build()
          StrictMode.setThreadPolicy(policy)

          val recebeDados = model
          var formBody: RequestBody = FormBody.Builder()
              .add("id_usuario"   ,recebeDados.id_usuario.toString())
              .add("nome"         ,recebeDados.nome)
              .add("email"        ,recebeDados.email)
              .add("tipo_usuario" ,recebeDados.tipo_usuario)
              .add("chave_usuario",recebeDados.chave_usuario)
              .add("senha"        ,recebeDados.senha)
              .add("rg"           ,recebeDados.rg)
              .add("cpf"          ,recebeDados.cpf)
              .add("endereco"     ,recebeDados.endereco)
              .add("estado"       ,recebeDados.estado)
              .add("pais"         ,recebeDados.pais)
              .add("cep"          ,recebeDados.cep)
              .add( "fone"        ,recebeDados.fone)
              .build()


          var client = OkHttpClient().newBuilder()
              .build()


          var request: Request = Request.Builder()
              .url(EnderecoWeb+Porta+Rota)
              .method(Metodo,formBody)
              .addHeader(TituloHeader01, ValorHeader01)
              .build()


          client.newCall(request).enqueue(object : Callback {
              override fun onFailure(call: Call, e: IOException) {}


              @Throws(IOException::class)
              override fun onResponse(call: Call, response: Response) {

                  try {

                      var data = response.body()?.string()



                  } catch (e: JSONException) {
                      e.printStackTrace()
                  }
              }
          })
      } // final do Update
    //----------------------------------------------------
    fun Insert_OkHttp(model:model){
        var policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val recebeDados = model
        Metodo = "POST"



        var formBody: RequestBody = FormBody.Builder()
            .add("nome",         recebeDados.nome)
            .add("email"        ,recebeDados.email)
            .add("tipo_usuario" ,recebeDados.tipo_usuario)
            .add("chave_usuario",recebeDados.chave_usuario)
            .add("senha"        ,recebeDados.senha)
            .add("rg"           ,recebeDados.rg)
            .add("cpf"          ,recebeDados.cpf)
            .add("endereco"     ,recebeDados.endereco)
            .add("estado"       ,recebeDados.estado)
            .add("pais"         ,recebeDados.pais)
            .add("cep"          ,recebeDados.cep)
            .add( "fone"        ,recebeDados.fone)
            .build()


        var client = OkHttpClient().newBuilder()
            .build()


        var request: Request = Request.Builder()
            .url(EnderecoWeb+Porta+Rota)
            .method(Metodo,formBody)
            .addHeader(TituloHeader01, ValorHeader01)
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}


            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {

                    try {

                        var data = response.body()?.string()



                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
               }
            })
    } // final do insert
   //-----------------------------------------------------

}