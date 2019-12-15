/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Compra;
import br.edu.ifnmg.Mercearia.DomainModel.Produto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            PreparedStatement sql  = this.getConexao()
                  .prepareStatement("insert into Compras(valorTotal, FornecedorFK, quantidade) values(?,?,?)",
                          Statement.RETURN_GENERATED_KEYS);
            sql.setFloat(1, obj.getValorTotal());
            //sql.setDate(2, (Date) obj.getDtVenda());
            sql.setInt(2, obj.getFornecedor().getId());
            sql.setInt(3, obj.getQuantidade());
            //sql.setInt(4, obj.getProduto().getId());
            
            
            if(sql.executeUpdate()>0){
                                  
                ResultSet chave = sql.getGeneratedKeys();
                chave.next();
                obj.setId(chave.getInt(1));
                
                insere_produtos(obj);
                return true;
            }else
                
                return false;
           }else{
                PreparedStatement sql = this.getConexao()
                    .prepareStatement("update Compras valorTotal =?, FornecedorFK=? , quantidade=?, where id = ?");
              sql.setFloat(1, obj.getValorTotal());
             // sql.setDate(2, (Date) obj.getDtVenda());
              sql.setInt(2, obj.getFornecedor().getId());
              sql.setInt(3, obj.getQuantidade());
             // sql.setInt(4, obj.getProduto().getId());
              insere_produtos(obj);
             

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
    
     
     private void insere_produtos(Compra compra) throws SQLException{
         for (Produto produto : compra.getProdutos()) {
             PreparedStatement sql2 = this.getConexao()
                     .prepareStatement("insert into itensCompra(compra_id, produtoFK) values(?,?)");
             sql2.setInt(1, compra.getId());
             sql2.setInt(2, produto.getId());
             sql2.executeUpdate();
             
         }
     }
    
    public Compra Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Compras where id = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Compra compra =  new Compra();
         
            
              try {
                   
                   compra.setId(resultado.getInt("Id"));
                   compra.setValorTotal(resultado.getFloat("ValorTotal"));
                   //compra.set(3, obj.getFornecedor().getId());
                   compra.setQuantidade(resultado.getInt("Quantidade"));  
                   ProdutoRepositorio prod_repo = new ProdutoRepositorio();
                   Produto prod = prod_repo.Abrir(resultado.getInt("produttoFK"));
                   
                   //compra.setProduto(prod);
                   
             } catch(Exception ex){
                 return null;
             }
              
              PreparedStatement sql2  = this.getConexao()
                      .prepareStatement("select produto_fk from itensCompra where compraFK=?");
              
              sql2.setInt(1, id);
              ResultSet resultado2 = sql2.executeQuery();
              ProdutoRepositorio produto_repo = new ProdutoRepositorio();
              while(resultado2.next()){
                  Produto produto = produto_repo.Abrir(resultado.getInt("produtoFK"));
                  //compra.addProduto(produto);
              }
             
             
           return compra;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
  
    
    
}
