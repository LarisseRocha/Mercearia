/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Estado;
import br.edu.ifnmg.Mercearia.DomainModel.Fornecedor;
import br.edu.ifnmg.Mercearia.DomainModel.Situacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Larisse
 */
public class FornecedorRepositorio extends BancoDados {
    
    public FornecedorRepositorio(){
        super();
    }
    public boolean Salvar(Fornecedor obj){
       try{
           
          if(obj.getId() == 0){
            PreparedStatement sql =  this.getConexao()
                .prepareStatement("insert into Fornecedores(cnpj, razaoSocial, email, rua, numero, bairro, cidade, estado, situacao) values(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            sql.setString(1, obj.getCnpj().replace(".", " ").replace("/", " ").replace("-", " "));
            sql.setString(2, obj.getRazaoSocial());
            sql.setString(3, obj.getEmail());
            sql.setString(4, obj.getRua());
            sql.setString(5, obj.getNumero());
            sql.setString(6, obj.getBairro());
            sql.setString(7, obj.getCidade());
            sql.setString(8, obj.getEstado().name());
            sql.setString(9, obj.getSituacao().name());
            
            
            if(sql.executeUpdate() > 0){
                return true;
          }
            else 
                return false;
          }else{
               PreparedStatement sql = this.getConexao()
                       .prepareStatement("update Fornecedores set cnpj = ?, razaoSocial = ?, email = ?, rua=?, numero =?, bairro=?, cidade=?, estado=?, situacao = ? where id = ?");
               
               sql.setString(1, obj.getCnpj().replace(".", " ").replace("/", " ").replace("-", " "));
               sql.setString(2, obj.getRazaoSocial());
               sql.setString(3, obj.getEmail());
               sql.setString(4, obj.getRua());
               sql.setString(5, obj.getNumero());
               sql.setString(6, obj.getBairro());
               sql.setString(7, obj.getCidade());
               sql.setString(8, obj.getEstado().name());
               sql.setString(9, obj.getSituacao().name());
               
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
    
    public void atualizarTelefones(Fornecedor fornecedor){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from FornecedorsTelefone where fornecedor_id = ?");
            
            sql.setInt(1, fornecedor.getId());
            
           sql.execute();
           
           PreparedStatement sql2 = this.getConexao()
                   .prepareStatement("insert into FornecedorsTelefone(fornecedor_id, telefone) VALUES (?, ?) ");
                
            
            
    
            for(String telefone : fornecedor.getTelefones()){
                sql2.setInt(1, fornecedor.getId());
                sql2.setString(2, telefone);
                sql2.execute();
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void abrirTelefones(Fornecedor fornecedor){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select telefone from FornecedorsTelefone where fornecedor_id = ?");
            
            sql.setInt(1, fornecedor.getId());
            
            ResultSet resultado = sql.executeQuery();
            
            while(resultado.next()){
                fornecedor.addTelefone(resultado.getString("telefone"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Fornecedor Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Fornecedors where id = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Fornecedor fornecedor = new Fornecedor();
         
            
            
              try {
                  
                        fornecedor.setId(resultado.getInt("id"));
                        fornecedor.setCnpj(resultado.getString("cnpj"));
                        fornecedor.setRazaoSocial(resultado.getString("razaoSocial"));
                        fornecedor.setEmail(resultado.getString("email"));
                        fornecedor.setRua(resultado.getString("rua"));
                        fornecedor.setNumero(resultado.getString("numero"));
                        fornecedor.setBairro(resultado.getString("bairro"));
                        fornecedor.setCidade(resultado.getString("cidade"));
                        fornecedor.setEstado(Estado.valueOf(resultado.getString("estado")));
                        fornecedor.setSituacao(Situacao.valueOf(resultado.getString("situacao")));
               
             } catch(Exception ex){
                 fornecedor = null;
             }
             

             
            return fornecedor;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
