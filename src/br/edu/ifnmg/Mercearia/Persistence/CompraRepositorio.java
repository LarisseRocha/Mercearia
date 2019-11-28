/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Compra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Larisse
 */
public class CompraRepositorio extends BancoDados {
    
    public CompraRepositorio(){
        super();
    }
    
    public boolean Salvar(Compra obj){
        
       try{
          if(obj.getId() == 0){
            PreparedStatement sql = this.getConexao()
                  .prepareStatement("insert into Compras(valorTotal, dtVenda, operador, Fornecedor) values(?,?,?,?)");
            sql.setFloat(1, obj.getValorTotal());
            sql.setDate(2, (Date) obj.getDtVenda());
            sql.setInt(3, obj.getFornecedor().getId());
            
            
            if(sql.executeUpdate()>0){
                return true;
            }else
                return false;
           }else{
                PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Compras valorTotal =?, dtVenda=?, operador=?, Fornecedor=? where id = ?");
              sql.setFloat(1, obj.getValorTotal());
              sql.setDate(2, (Date) obj.getDtVenda());
              sql.setInt(3, obj.getFornecedor().getId());
             

              if(sql.executeUpdate()>0){
                  return true;
              }else
                  return false;
          }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
  
    
    
}
