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
public class FornecedorRepositorio extends DataBase {
    public boolean Salvar(Fornecedor obj){
       try{
           
          if(obj.getId() == 0){
            PreparedStatement sql =  this.getConexao()
                .prepareStatement("insert into Fornecedors(cnpj, razaoSocial) values(?,?)");
            
            sql.setInt(1, obj.getCnpj());
            sql.setString(2, obj.getRazaoSocial().replace(".", "").replace("-", ""));
            
            if(sql.executeUpdate() > 0){
                return true;
          }
            else 
                return false;
          }else{
               PreparedStatement sql = this.getConexao()
                       .prepareStatement("update Fornecedors set cnpj = ?, razaoSocial =? where id = ?");
               
               sql.setInt(1, obj.getCnpj());
               sql.setString(2, obj.getRazaoSocial().replace(".", "").replace("-", ""));
               sql.setInt(3, obj.getId());
               
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
            Fornecedor produto = new Fornecedor();
         
            produto.setId(resultado.getInt("id"));
            produto.setCnpj(resultado.getInt("cnpj"));
            produto.setRazaoSocial(resultado.getString("cpf"));
           
             
            return produto;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
