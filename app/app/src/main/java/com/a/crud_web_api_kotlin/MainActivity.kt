package com.a.crud_web_api_kotlin

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.crud_web_api_kotlin.ConsumoAPI.OkHttpListagem.ConsumoLista
import com.a.crud_web_api_kotlin.Repository.Repository
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
    private var listaUsuarios = ArrayList<model>()
    lateinit var adapter:adapter



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //---------------------------
        setupRecyclerview()
        CarregaLista()

        Atualiza.setOnClickListener { view ->

            CarregaLista()
        }

        floatingActionButton.setOnClickListener { view ->
                UserViewModel = ViewModelProvider(this).get(ViewModel::class.java)

                val viewActionButton = window.decorView
                telasDialog(viewActionButton, this,UserViewModel).criaInsert_ActionDialog()
        }

      }//fim do oncreate


    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupRecyclerview(){
        teste.setText("")
        val view = window.decorView
        UserViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        adapter = adapter(listaUsuarios,view, this,UserViewModel)
        recyclerViewID.setAdapter(adapter)
        recyclerViewID.layoutManager = LinearLayoutManager (this)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun CarregaLista(){
        val view = window.decorView
        UserViewModel = ViewModelProvider(this).get(ViewModel::class.java)



         ConsumoLista().Lista_OkHttp().observe( this,Observer<ArrayList<model>> {it:ArrayList<model> ->
           listaUsuarios.clear()
           listaUsuarios.addAll(it)
           adapter.addList(listaUsuarios)

         })



        /*
        ***Exemplo de uso com observeforever, tambem funciona
        ConsumoLista().Lista_OkHttp().ListAll().observeForever({
          listaUsuarios.clear()
          listaUsuarios.addAll(it)
          adapter.addList(listaUsuarios)
        })
        */
    }

}// fim da classe






