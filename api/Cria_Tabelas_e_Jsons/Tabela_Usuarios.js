/*
create table usuarios (
    id_usuario    int not null PRIMARY KEY AUTO_INCREMENT,
    tipo_usuario   varchar(50)  not null,
    chave_usuario  varchar(50)  not null,
    nome           varchar(50)  not null,
    email          varchar(100) not null UNIQUE,
    senha          varchar(32)  not null,
    RG             VARCHAR(100) NOT NULL UNIQUE, 
    CPF            VARCHAR(100) NOT NULL UNIQUE, 
    endereco       VARCHAR(100) NOT NULL, 
    estado         VARCHAR(100) NOT NULL, 
    pais           VARCHAR(100) NOT NULL, 
    cep            VARCHAR(100) NOT NULL, 
    fone           VARCHAR(100) NOT NULL
)



  Manual de uso da API

-Todos os campos são de preenchimento obrigatório
-Campos EMAIL, CPF, RG são UNIQUE, portanto não podem repetir.
-Para maior liberdade de alterações todos campos são CHAR no MySQL         
------------------------------------------------------
------------------------------------------------------
Metodo post / Inserção:
    
     {
    "chave_unica" : "teste" ,
    "tipo_usuario" : "Administrador",
    "chave_usuario": "teste@teste.com",
    "nome"         : "teste",
    "email"        : "teste@teste.com",
    "senha"        : "123",
    "rg"           : "123321456", 
    "cpf"          : "00642057036", 
    "endereco"     : "rua teste ", 
    "estado"       : "RS", 
    "pais"         : "BR", 
    "cep"          : "93600000", 
    "fone"         : "1232"
    } 
    
------------------------------------------------------
Metodo GET / Listagem:
http://ENDEREÇO:3000/usuarios

     {
    "chave_unica" : "teste"  
    } 

------------------------------------------------------
Metodo GET / Lista um:
http://ENDEREÇO:3000/usuarios/id_usuario

     {
    "chave_unica" : "teste" 
    } 
------------------------------------------------------
Metodo DELETE / Apaga um usuario:    
    {
    "chave_unica" : "teste",  
    "id_usuario" : 6    
    } 
------------------------------------------------------
Metodo PATCH / Alteração:
    
      {
    "id_usuario": 7,  
    "chave_unica" : "teste",
    "chave_usuario":"9teste@teste.com",
    "tipo_usuario" : "Administrador",
    "nome"         : "bip bip",
    "email"        : "9teste@teste.com",
    "senha"        : "123",
    "rg"           : "12321", 
    "cpf"          : "00642057036000", 
    "endereco"     : "rua teste ", 
    "estado"       : "RS", 
    "pais"         : "BR", 
    "cep"          : "93600000", 
    "fone"         : "1232"
     } 
------------------------------------------------------



*/