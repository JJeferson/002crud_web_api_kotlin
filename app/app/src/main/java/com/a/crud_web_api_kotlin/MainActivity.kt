package com.a.crud_web_api_kotlin

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.crud_web_api_kotlin.ConsumoAPI.RetrofitListagemUsuarios.ViewModelListaUsers
import com.a.crud_web_api_kotlin.ViewModel.ViewModel
import com.a.crud_web_api_kotlin.adapter.adapter
import com.a.crud_web_api_kotlin.model.model
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class MainActivity : AppCompatActivity()   {



    private lateinit var UserViewModel: ViewModel

    lateinit var adapter:adapter
    lateinit var viewModelListaUsers: ViewModelListaUsers
    lateinit var UsersList : ArrayList<model>


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //---------------------------


        getUsersData()
        componentesdaTela()
        floatingActionButton.setOnClickListener { view ->

                UserViewModel = ViewModelProvider(this).get(ViewModel::class.java)

                val viewActionButton = window.decorView
                telasDialog(viewActionButton, this,UserViewModel).criaInsert_ActionDialog()

        }

      }//fim do oncreate

      @RequiresApi(Build.VERSION_CODES.N)
      fun componentesdaTela() {
          teste.setText("")
          val view = window.decorView
          UserViewModel = ViewModelProvider(this).get(ViewModel::class.java)


          //Adapter e RecyclerView
          adapter = adapter(UsersList,view, this,UserViewModel)
          recyclerViewID.setAdapter(adapter)
          recyclerViewID.layoutManager = LinearLayoutManager (this)
      }


    fun getUsersData(){

        UsersList = ArrayList()
        viewModelListaUsers = ViewModelProvider(this).get(ViewModelListaUsers::class.java)

        viewModelListaUsers.getUsersData().observe(this, Observer {
            UsersList.addAll(it)
            adapter.notifyDataSetChanged()
            })

    }




/*
//----------------------------------------------------
//descontinuado
 @Throws(JSONException::class)
 @RequiresApi(Build.VERSION_CODES.N)
 fun Lista_OkHttp()  {
    //view: View, adapter: adapter, context: Context
     listaUsuarios.clear()


     var policy =
         StrictMode.ThreadPolicy.Builder().permitAll().build()
         StrictMode.setThreadPolicy(policy)

     var client = OkHttpClient().newBuilder()
         .build()


     var request: Request = Request.Builder()
         .url("http://192.168.0.104:3000/usuarios")
         .method("GET", null)
         .addHeader("chave_unica", "teste")
         //.header("chave_unica", "teste")

         .build()

     //--------------------------------------------


     client.newCall(request).enqueue(object : Callback {
         override fun onFailure(call: Call, e: IOException) {}


         @Throws(IOException::class)
         override fun onResponse(call: Call, response: Response) {

                 try {

                     var data = response.body()?.string()
                     //-----------------------
                     var jsonArray = JSONArray(data)

                     var contador: Int = 0
                     var tamanhoLista = jsonArray.length()
                     //menor ou igual
                     while (contador <= tamanhoLista) {

                         var jsonObject = jsonArray.getJSONObject(contador)

                         contador = contador + 1


                         var recebeNome = jsonObject.get("nome").toString()
                         var recebeID_usuario =
                             Integer.parseInt(jsonObject.get("id_usuario").toString())
                         var recebeEmail = jsonObject.get("email").toString()

                         var Model = model(recebeID_usuario, recebeNome, recebeEmail)

                         listaUsuarios.add(Model)
                         adapter.notifyDataSetChanged()
                     }

                     //-----------------------

                 } catch (e: JSONException) {
                     e.printStackTrace()
                 }//Final do try

         }//Final do bloco de requisição


     })

 }//aqui termina a função lista

*/

}// fim da classe




