/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Mercearia.DomainModel.Estado;
import br.edu.ifnmg.Mercearia.DomainModel.Situacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                .prepareStatement("insert into Clientes(nome, cpf, email, rua, numero, bairro, cidade, estado, situacao) values(?,?,?,?,?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
            //recupera as chaves autoincrement do bd
            
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCpf().replace(".", " ").replace("/","").replace("-", " "));
            sql.setString(3, obj.getEmail());
            sql.setString(4, obj.getRua());
            sql.setString(5, obj.getNumero());
            sql.setString(6, obj.getBairro());
            sql.setString(7, obj.getCidade());
            sql.setString(8, obj.getEstado().name());
            sql.setString(9, obj.getSituacao().name());
            
         

                        
            if(sql.executeUpdate() > 0){
                ResultSet res = sql.getGeneratedKeys();
                res.next();
                obj.setId(res.getInt(1));
                atualizarTelefones(obj);
                return true;
          }
            else 
                return false;
          }else{
               PreparedStatement sql = this.getConexao()
                       .prepareStatement("update Clientes set nome = ?, cpf =?, email=?, numero = ?,rua =?, bairro = ?, cidade = ?, estado =?, situacao= =? where id = ?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getCpf().replace(".", " ").replace("/","").replace("-", " "));
                sql.setString(3, obj.getEmail());
                sql.setString(4, obj.getRua());
                sql.setString(5, obj.getNumero());
                sql.setString(6, obj.getBairro());
                sql.setString(7, obj.getCidade());
                sql.setString(8, obj.getEstado().name());
                sql.setString(9, obj.getSituacao().name());
                
            
              
               
               if(sql.executeUpdate()>0){
                   atualizarTelefones(obj);
                   return true;
               }
               else
                   return false;
         }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
        return false;
    }
    
    
     public void atualizarTelefones(Cliente cliente){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("delete from ClientesTelefone where cliente_id = ?");
            
           sql.setInt(1, cliente.getId());
            
           sql.executeUpdate();
           
           PreparedStatement sql2 = this.getConexao()
                   .prepareStatement("insert into ClientesTelefone(cliente_id, telefone) VALUES (?,?) ");
                
            
            
    
            for(String telefone : cliente.getTelefones()){
                sql2.setInt(1, cliente.getId());
                sql2.setString(2, telefone);
                sql2.executeUpdate();
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void abrirTelefones(Cliente cliente){
        try {
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select telefone from ClientesTelefone where cliente_id = ?");
            
            sql.setInt(1, cliente.getId());
            
            ResultSet resultado = sql.executeQuery();
            
            while(resultado.next()){
                cliente.addTelefone(resultado.getString("telefone"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao abrir telefone");
        }
    }

    public Cliente Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Clientes where id = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Cliente cliente =  new Cliente();
            
            
         
            
            
              try {
                    cliente.setId(resultado.getInt("id"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setCpf(resultado.getString("cpf"));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setRua(resultado.getString("rua"));
                    cliente.setNumero(resultado.getString("numero"));
                    cliente.setBairro(resultado.getString("bairro"));
                    cliente.setCidade(resultado.getString("cidade"));
                    cliente.setEstado(Estado.valueOf(resultado.getString("estado")));
                    cliente.setSituacao(Situacao.valueOf(resultado.getString("situacao")));
                    
               
             } catch(Exception ex){
                 cliente = null;
             }
             
           
             
            return cliente;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
      public List<Cliente> Buscar(Cliente filtro){
         
         try{
             String where = "";
             if(filtro != null){
                 if(filtro.getId()!=0)
                     where+= "id = '"+filtro.getId()+"'";
                 if(filtro.getNome() != null && !filtro.getNome().isEmpty())
                    where += "descricao like '%"+filtro.getNome() + "%'";
             }
             
                
            String consulta = "select * from Produtos ";
            if(where.length()>0){
                consulta+= " where  "+where;
            }
             
             
             
             PreparedStatement sql = this.getConexao()
                        .prepareStatement(consulta);
                ResultSet resultado = sql.executeQuery();
                List<Cliente> produtos = new ArrayList();

                while(resultado.next()){
                    Cliente c = new Cliente();
                try{
                    c.setId(resultado.getInt("id"));
                    c.setNome(resultado.getString("nome"));
                    c.setCpf(resultado.getString("cpf"));
                   
            
                  
                }catch(Exception ex){
                    c = null;
                }
                   produtos.add(c);

                }

               return produtos;
             
               
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }
             
        return null; 
     }
    


    


    
    
}
