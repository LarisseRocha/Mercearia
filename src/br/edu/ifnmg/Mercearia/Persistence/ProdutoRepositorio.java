/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larisse
 */
public class ProdutoRepositorio extends BancoDados {
    public ProdutoRepositorio(){
        super();
    }
    
    public boolean Salvar(Produto obj){
        
        try{
            if(obj.getId() == 0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Produtos(descricao, uniCompra, uniVenda, prCompra, prVenda, fornecedorFK) values(?,?,?,?,?,?)");
                sql.setString(1, obj.getDescricao());
                sql.setInt(2, (int) obj.getUniCompra());
                sql.setInt(3, (int) obj.getUniVenda());
                sql.setFloat(4, obj.getPrCompra());
                sql.setFloat(5, obj.getPrVenda());
                sql.setInt(6, obj.getFornecedor().getId() );
               // System.out.println(obj.getFornecedor().getId());
                
                

                if(sql.executeUpdate()>0){
                     return true;
                }else
                    return false;
            }else{
                    PreparedStatement sql = this.getConexao()
                        .prepareStatement("update set Produtos descricao =?, uniCompr=?, uniVenda=?, prCompra=?, prVenda=?, fornecedorFK=?");
                sql.setString(1, obj.getDescricao());
                sql.setInt(2, (int) obj.getUniCompra());
                sql.setInt(3, (int) obj.getUniVenda());
                sql.setFloat(4, obj.getPrCompra());
                sql.setFloat(5, obj.getPrVenda());
                sql.setInt(6, obj.getFornecedor().getId());
                
                
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
    
    public Produto Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Produtos where id = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Produto produto = new Produto();
         
            produto.setId(resultado.getInt("id"));
            produto.setDescricao(resultado.getString("descricao"));
            produto.setPrVenda(resultado.getInt("UniCompra"));
            produto.setPrVenda(resultado.getInt("UniVenda"));
            produto.setPrCompra(resultado.getFloat("prCompra"));
            produto.setPrVenda(resultado.getFloat("prVenda"));
           
            
             
            return produto;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
     public List<Produto> Buscar(Produto filtro){
         
         try{
             String where = "";
             if(filtro != null){
                 if(filtro.getId()!=0)
                     where+= "id = '"+filtro.getId()+"'";
                 if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty())
                    where += "descricao like '%"+filtro.getDescricao() + "%'";
             }
             
                
            String consulta = "select * from Produtos ";
            if(where.length()>0){
                consulta+= " where  "+where;
            }
             
             
             
             PreparedStatement sql = this.getConexao()
                        .prepareStatement(consulta);
                ResultSet resultado = sql.executeQuery();
                List<Produto> produtos = new ArrayList();

                while(resultado.next()){
                    Produto p = new Produto();
                try{
                    p.setId(resultado.getInt("id"));
                    p.setDescricao(resultado.getString("descricao"));
                    p.setUniCompra(resultado.getInt("uniCompra"));
                    p.setUniVenda(resultado.getInt("uniVenda"));
                    p.setPrCompra(resultado.getFloat("prCompra"));
                    p.setPrVenda(resultado.getFloat("prVenda"));
                  
            
                  
                }catch(Exception ex){
                    p = null;
                }
                   produtos.add(p);

                }

               return produtos;
             
               
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }
             
        return null; 
     }
    
}

    

