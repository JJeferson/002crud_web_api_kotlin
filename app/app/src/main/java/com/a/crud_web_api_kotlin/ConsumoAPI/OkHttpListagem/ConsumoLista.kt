package com.a.crud_web_api_kotlin.ConsumoAPI.OkHttpListagem

import android.os.Build
import android.os.StrictMode
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.a.crud_web_api_kotlin.model.model
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class ConsumoLista  {

    @Throws(JSONException::class)
    @RequiresApi(Build.VERSION_CODES.N)

    fun Lista_OkHttp(): MutableLiveData<ArrayList<model>> {
        //view: View, adapter: adapter, context: Context
        var LiveData = MutableLiveData<ArrayList<model>>()
        var listaUsuarios = ArrayList<model>()
       listaUsuarios.clear()
       //LiveData.postValue(listaUsuarios)




        var policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var client = OkHttpClient().newBuilder()
            .build()


        var request: Request = Request.Builder()
            .url("http://192.168.0.104:3000/usuarios")
            .method("GET", null)
            .addHeader("chave_unica", "teste")
            .build()

        //--------------------------------------------


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}


            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {

                try {
                    var data = response.body()?.string()
                    var jsonArray = JSONArray(data)
                    var contador: Int = 0
                    var tamanhoLista = jsonArray.length()
                    while (contador <= tamanhoLista) {

                        var jsonObject = jsonArray.getJSONObject(contador)

                        contador = contador + 1


                        var recebeNome = jsonObject.get("nome").toString()
                        var recebeID_usuario =
                            Integer.parseInt(jsonObject.get("id_usuario").toString())
                        var recebeEmail = jsonObject.get("email").toString()

                        var Model = model(recebeID_usuario, recebeNome, recebeEmail)

                        listaUsuarios.add(Model)

                    }

                    //-----------------------

                } catch (e: JSONException) {
                    e.printStackTrace()
                }//Final do try

            }//Final do bloco de requisição


        })
     LiveData.postValue(listaUsuarios)
     return LiveData
    }
}