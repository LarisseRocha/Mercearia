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
                .prepareStatement("insert into Clientes(nome, cpf, email, rua, numero, bairro, cidade, estado, situacao) values(?,?,?,?,?,?,?,?,?)");
            
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCpf().replace(".", " ").replace("-", " "));
            sql.setString(3, obj.getEmail());
            sql.setString(4, obj.getRua());
            sql.setInt(5, obj.getNumero());
            sql.setString(6, obj.getBairro());
            sql.setString(7, obj.getCidade());
            sql.setString(8, obj.getEstado());
            sql.setBoolean(9, obj.isSituacao());
            
            
            if(sql.executeUpdate() > 0){
                return true;
          }
            else 
                return false;
          }else{
               PreparedStatement sql = this.getConexao()
                       .prepareStatement("update Clientes set nome = ?, cpf =?, email=?, numero = ?,rua =?, bairro = ?, cidade = ?, estado =?, situacao= =? where id = ?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", " ").replace("-", " "));
                sql.setString(3, obj.getEmail());
                sql.setString(4, obj.getRua());
                sql.setInt(5, obj.getNumero());
                sql.setString(6, obj.getBairro());
                sql.setString(7, obj.getCidade());
                sql.setString(8, obj.getEstado());
                sql.setBoolean(9, obj.isSituacao());
            
              
               
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
            cliente.setEmail(resultado.getString("email"));
            cliente.setRua(resultado.getString("rua"));
            cliente.setNumero(resultado.getInt("numero"));
            cliente.setBairro(resultado.getString("bairro"));
            cliente.setCidade(resultado.getString("cidade"));
            cliente.setEstado(resultado.getString("estado"));
            cliente.setSituacao(resultado.getBoolean("situacao"));
           
             
            return cliente;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
}
