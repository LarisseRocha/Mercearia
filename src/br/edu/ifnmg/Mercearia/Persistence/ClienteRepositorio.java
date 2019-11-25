/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Larisse
 */
public class ClienteRepositorio extends BancoDados {
    
    public ClienteRepositorio(){
       super(); 
    }
    
    public boolean Salvar(Cliente obj){
       try{
           
          if(obj.getId() == 0){
            PreparedStatement sql =  this.getConexao()
                .prepareStatement("insert into Clientes(nome, cpf, situacao) values(?,?,?)");
            
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
            sql.setBoolean(3, obj.isSituacao());
            
            if(sql.executeUpdate() > 0){
                return true;
          }
            else 
                return false;
          }else{
               PreparedStatement sql = this.getConexao()
                       .prepareStatement("update Clientes set nome = ?, cpf =? situacao= =? where id = ?");
               sql.setInt(1, obj.getId());
               sql.setString(2, obj.getNome());
               sql.setString(3, obj.getCpf().replace(".", "").replace("-", ""));
               sql.setBoolean(4, obj.isSituacao());
              
               
               if(sql.executeUpdate()>0)
                   return true;
               else
                   return false;
         }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        return false;
    }
    public Cliente Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Clientes where id = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Cliente cliente = new Cliente();
         
            cliente.setId(resultado.getInt("id"));
            cliente.setNome(resultado.getString("nome"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setSituacao(resultado.getBoolean("situacao"));
           
             
            return cliente;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
}
