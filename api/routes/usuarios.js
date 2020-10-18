const express = require('express');
const router = express.Router();
const mysql   = require('../mysql').pool;

var chave_unica="teste";



//----------------------------------------------------------------------------------------------------
//Lista
router.get('/',(req, res, next) => {
    
    //---------------------------------
    //Segurança do metodo da rota 
    //metodo get autentica somente via header
    if (req.headers.chave_unica===chave_unica){

     mysql.getConnection((error,conn) =>{
      if (error) {return res.status(500).send({error:error})}

       conn.query(
            'select * from usuarios order by id_usuario DESC',
            (error,resultado,fields) =>{
               
               if (error) {return res.status(500).send({error:error})}
            
                return res.status(200).send(resultado)
                
            }
       )
       conn.release();
       // o release precisa estar logo após a execução da 
       })
     
  }else{
          
    return res.status(500).send({
      mensagem:'Erro ao acessar a rota, Chave unica invalida',
      });

  }
  }
  );
//----------------------------------------------------------------------------------------------------

//Lista um
router.get('/:id_usuario',(req, res, next) => {
 
    //---------------------------------
    //Segurança do metodo da rota 
    //metodo get autentica somente via header
    if (req.headers.chave_unica===chave_unica){

     mysql.getConnection((error,conn) =>{
     if (error) {return res.status(500).send({error:error})}
 
     conn.query(
          'select * from usuarios where id_usuario= ?; ',
          [req.params.id_usuario],
          (error,resultado,fields) =>{
             
             if (error) {return res.status(500).send({error:error})}
          
              return res.status(200).send(resultado)
               
  
          }
     )
     conn.release();
      // o release precisa estar logo após a execução da 
      // query
  
  })
    }else{
          
    return res.status(500).send({
    mensagem:'Erro ao acessar a rota, Chave unica invalida',
    });

    }});

//----------------------------------------------------------------------------------------------------
//insert
router.post('/',(req, res, next) => {
 
    //---------------------------------
    //Segurança do metodo da rota 
    if (req.headers.chave_unica===chave_unica){

    const grava_ususario = { 
 

           tipo_usuario  : req.body.tipo_usuario,  
           chave_usuario : req.body.chave_usuario, 
           nome          : req.body.nome,        
           email         : req.body.email,        
           senha         : req.body.senha,        
           rg            : req.body.rg,         
           cpf           : req.body.cpf,         
           endereco      : req.body.endereco,     
           estado        : req.body.estado,        
           pais          : req.body.pais,            
           cep           : req.body.cep,         
           fone          : req.body.fone         

     
     }
 
     mysql.getConnection((error,conn) =>{
           conn.query(
              `insert into usuarios
              (tipo_usuario,chave_usuario,nome,email,senha,rg,cpf,endereco,estado,pais,cep,fone)
               values (?,?,?
                      ,?,?,?
                      ,?,?,?
                      ,?,?,?)`,
              [req.body.tipo_usuario,
               req.body.chave_usuario,  
               req.body.nome,
               req.body.email,
               req.body.senha,
               req.body.rg,
               req.body.cpf,
               req.body.endereco,
               req.body.estado,
               req.body.pais,
               req.body.cep,
               req.body.fone],
              (error, resultado, field) =>{
                  
   
                     if (error){
                         return res.status(500).send({
                           error:error,
                           mensagem:'erro na inserção',
                           response:null
     
   
                         });  
                         
                     } 
   
                     res.status(201).send({
                           mensagem:'Insere Usuarios: ',
                           mensagem:'Cadastrado',
                           usuarioCriado: grava_ususario
   
                     }); 
              }
            
           )
           conn.release();
         // o release precisa estar logo após a execução da 
         // query
       })


        }else{
          
        return res.status(500).send({
        mensagem:'Erro ao acessar a rota, Chave unica invalida',
        });
    
        }});

//----------------------------------------------------------------------------------------------------

//Alteração o Update
router.patch('/',(req, res, next) => {
   
    //---------------------------------
    //Segurança do metodo da rota  
    if (req.headers.chave_unica===chave_unica){
    
    //validação para não passar campo vasio  
    const testa_tipo_usuario = req.body.tipo_usuario;
    if (!testa_tipo_usuario){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo tipo_usuario não preenchido',
        });
    }
    const testa_chave_usuario = req.body.chave_usuario;
    if (!testa_chave_usuario){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo  chave_usuario  não preenchido',
        });
    }
    
    const testa_nome = req.body.nome;
    if (!testa_nome){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo nome não preenchido',
        });
    }
    
    const testa_email = req.body.email;
    if (!testa_email){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo email não preenchido',
        });
    }
    
    const testa_senha = req.body.senha;
    if (!testa_senha){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo senha não preenchido',
        });
    }
    
    const testa_rg = req.body.rg;
    if (!testa_rg){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo rg não preenchido',
        });
    }
    
    const testa_cpf = req.body.cpf;
    if (!testa_cpf){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo cpf não preenchido',
        });
    }
    
    const testa_endereco = req.body.endereco;
    if (!testa_endereco){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo endereco não preenchido',
        });
    }
    const testa_estado = req.body.estado;
    if (!testa_estado){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo estado não preenchido',
        });
    }
    const testa_pais = req.body.pais;
    if (!testa_pais){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo pais não preenchido',
        });
    }
    const testa_cep = req.body.cep;
    if (!testa_cep){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo cep não preenchido',
        });
    }
    const testa_fone = req.body.fone;
    if (!testa_fone){
        return res.status(500).send({
        mensagem:'Erro ao processar update, campo fone não preenchido',
        });
    }
    

 
    
    mysql.getConnection((error,conn) =>{
      conn.query(
         `update usuarios
          set 
              tipo_usuario         =?,
              chave_usuario        =?,
              nome                 =?,
              email                =?,
              senha                =?,
              rg                   =?,
              cpf                  =?,
              endereco             =?,
              estado               =?,
              pais                 =?,
              cep                  =?,
              fone                 =?
              where id_usuario     =?
             `,
         [
          req.body.tipo_usuario,
          req.body.chave_usuario,
          req.body.nome,
          req.body.email,
          req.body.senha,
          req.body.rg,
          req.body.cpf,
          req.body.endereco,
          req.body.estado,
          req.body.pais,
          req.body.cep,
          req.body.fone,
          req.body.id_usuario],
         (error, resultado, field) =>{
            
  
                if (error){
                    return res.status(500).send({
                      error:error,
                      response:null
  
  
                    });  
                    
                }
         
                res.status(201).send({
                      mensagem:'Usuario alterado'
                     
  
                }); 
  
         }
       
      )
      conn.release();
      // o release precisa estar logo após a execução da 
      // query
  })

  
  }else{
          
  return res.status(500).send({
  mensagem:'Erro ao acessar a rota, Chave unica invalida',
  });
}//final da  validação dos campos

  });
  


//----------------------------------------------------------------------------------------------------
//Delete
router.delete('/',(req, res, next) => {
   
 
      //---------------------------------
      //Segurança do metodo da rota 
      if (req.headers.chave_unica===chave_unica){

      mysql.getConnection((error,conn) =>{
      conn.query(
         `delete from usuarios where id_usuario=?`,
         [req.body.id_usuario],
         (error, resultado, field) =>{
            
                if (error){
                    return res.status(500).send({
                      error:error,
                      response:null
  
  
                    });  
                    
                } 
                res.status(201).send({
                      mensagem:'Usuario Apagado'
                     
  
                }); 
                
         } 
      )
      conn.release();
      // o release precisa estar logo após a execução da 
      // query
  })

  }else{
          
  return res.status(500).send({
  mensagem:'Erro ao acessar a rota, Chave unica invalida',
  });
  }});

  

//----------------------------------------------------------------------------------------------------
module.exports = router;