/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Larisse
 */
public class FornecedorRepositorio extends BancoDados {
    public boolean Salvar(Fornecedor obj){
       try{
           
          if(obj.getId() == 0){
            PreparedStatement sql =  this.getConexao()
                .prepareStatement("insert into Fornecedores(cnpj, razaoSocial, email, rua, numero, bairro, cidade, estado, situacao) values(?,?,?,?,?,?,?,?,?)");
            
            sql.setInt(1, obj.getCnpj());
            sql.setString(2, obj.getRazaoSocial().replace(".", "").replace("-", ""));
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
                       .prepareStatement("update Fornecedors set cnpj = ?, razaoSocial =?, email=?, rua=?, numero =?, bairro=?, cidade=?, estado=?, situacao = ? where id = ?");
               sql.setInt(1, obj.getId());
               sql.setInt(2, obj.getCnpj());
               sql.setString(3, obj.getRazaoSocial().replace(".", "").replace("-", ""));
               sql.setString(4, obj.getEmail());
               sql.setString(5, obj.getRua());
               sql.setInt(6, obj.getNumero());
               sql.setString(7, obj.getBairro());
               sql.setString(8, obj.getCidade());
               sql.setString(9, obj.getEstado());
               sql.setBoolean(10, obj.isSituacao());
               
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
    
    
     public Fornecedor Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Fornecedors where id = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Fornecedor fornecedor = new Fornecedor();
         
           fornecedor.setId(resultado.getInt("id"));
           fornecedor.setCnpj(resultado.getInt("cnpj"));
           fornecedor.setRazaoSocial(resultado.getString("razaoSocial"));
           fornecedor.setEmail(resultado.getString("email"));
           fornecedor.setRua(resultado.getString("rua"));
           fornecedor.setNumero(resultado.getInt("numero"));
           fornecedor.setBairro(resultado.getString("bairro"));
           fornecedor.setCidade(resultado.getString("cidade"));
           fornecedor.setEstado(resultado.getString("estado"));
           fornecedor.setSituacao(resultado.getBoolean("situacao"));
           
             
            return fornecedor;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
