package com.a.crud_web_api_kotlin

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a.crud_web_api_kotlin.ConsumoAPI.CRUD
import com.a.crud_web_api_kotlin.ViewModel.ViewModel
import com.a.crud_web_api_kotlin.model.model
import kotlinx.android.synthetic.main.insert_actiondialog.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.ArrayList

class telasDialog(private var view: View,
                  private var context: Context,
                  UserViewModel: ViewModel){

    var userViewModel = UserViewModel
    //--------------------------------------------------------------------------
    fun criaDELETE_ActionDialog(ID:Int){

        var recebeID = ID

        var view_AlertDialogExcluir =  LayoutInflater.from(context).
        inflate(R.layout.alertdialog_excluir,view as ViewGroup,false)
        //-----------------------------//

        AlertDialog.Builder(context).
        setTitle("").
        setView(view_AlertDialogExcluir).
        setPositiveButton("Sim",
            DialogInterface.OnClickListener { dialogInterface, i ->

                val EnviaDados = model(id_usuario = recebeID)
                userViewModel.deleteUser(EnviaDados)
            }).
        setNegativeButton("Não",null).
        show()
    }
    //--------------------------------------------------------------------------

    fun criaInsert_ActionDialog() {

        var view_AlertDialog =  LayoutInflater.from(context).
        inflate(R.layout.insert_actiondialog,view as ViewGroup,false)
        //-----------------------------//

        AlertDialog.Builder(context).
        setTitle("").
        setView(view_AlertDialog).
        setPositiveButton("Gravar",
            DialogInterface.OnClickListener { dialogInterface, i ->

                var recebeNome  = view_AlertDialog.actionDialog_NomeID.text.toString()
                var recebeEmail = view_AlertDialog.actionDialog_EmailID.text.toString()

                val EnviaDados = model(nome=recebeNome,email=recebeEmail)
                userViewModel.addUser(EnviaDados)

            }).
        setNegativeButton("Sair",null).
        show()
    }

    //----------------------------------------

    fun criaEditar_ActionDialog(id:Int,RecebeNome:String,RecebeEmail:String) {

        var view_AlertDialog =  LayoutInflater.from(context).
        inflate(R.layout.insert_actiondialog,view as ViewGroup,false)
        //-----------------------------//

        view_AlertDialog.titulo.setText("Alteração")
        view_AlertDialog.actionDialog_NomeID.setText(RecebeNome)
        view_AlertDialog.actionDialog_EmailID.setText(RecebeEmail)
        //-----------------------------//
        AlertDialog.Builder(context).
        setTitle("").
        setView(view_AlertDialog).
        setPositiveButton("Gravar",
            DialogInterface.OnClickListener { dialogInterface, i ->

                var recebeNome  = view_AlertDialog.actionDialog_NomeID.text.toString()
                var recebeEmail = view_AlertDialog.actionDialog_EmailID.text.toString()

                val EnviaDados = model(id_usuario = id,nome=recebeNome,email=recebeEmail)
                userViewModel.updateUser(EnviaDados)

            }).
        setNegativeButton("Sair",null).
        show()
    }



}