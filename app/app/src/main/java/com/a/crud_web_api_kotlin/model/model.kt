package com.a.crud_web_api_kotlin.model

import com.google.gson.annotations.SerializedName

class model(val id_usuario:Int       = 0,
            val nome: String         = "Não Preenchido",
            val email:String         = "Não Preenchido",
            val tipo_usuario:String  = "Não Preenchido",
            val chave_usuario:String = "Não Preenchido",
            val senha:String         = "Não Preenchido",
            val rg:String            = "Não Preenchido",
            val cpf:String           = "Não Preenchido",
            val endereco:String      = "Não Preenchido",
            val estado:String        = "RS",
            val pais:String          = "BR",
            val cep:String           = "Não Preenchido",
            val fone:String          = "Não Preenchido"

) {
}
