package com.a.crud_web_api_kotlin.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.a.crud_web_api_kotlin.R
import com.a.crud_web_api_kotlin.ViewModel.ViewModel
import com.a.crud_web_api_kotlin.model.model
import com.a.crud_web_api_kotlin.telasDialog
import kotlinx.android.synthetic.main.layout_lista_recyclerview.view.*


class adapter(
    var listaUsuarios: ArrayList<model> = ArrayList(),
    private var viewMain:View,
    private var context: Context,
    UserViewModel: ViewModel): RecyclerView.Adapter<adapter.MyViewHolder>()  {

    var userViewModel = UserViewModel
    var recebeLista = listaUsuarios



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_lista_recyclerview, parent, false))

    }

    fun addList(lista: ArrayList<model>){

        recebeLista = lista
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        //return userList.size
        return recebeLista.size

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = recebeLista[position]
        var id =  currentItem.id_usuario
        holder.itemView.nomeID.setText("ID: "+id+"  |     Nome do usuario:"+currentItem.nome)
        holder.itemView.emailID.setText("Email: "+currentItem.email)




        holder.itemView.layoutLinhaID.setOnClickListener {view: View ->
            var id = id
            var nome  = currentItem.nome
            var email = currentItem.email


            telasDialog(viewMain,context,userViewModel).criaEditar_ActionDialog(id,nome,email)
        }


        holder.itemView.layoutLinhaID.setOnLongClickListener{
            var id = id
            telasDialog(viewMain,context,userViewModel).criaDELETE_ActionDialog(id)
            //sendo esse metodo onLongClickListner não posso esquecer desse true boolean no final
            true
        }





    }



}

