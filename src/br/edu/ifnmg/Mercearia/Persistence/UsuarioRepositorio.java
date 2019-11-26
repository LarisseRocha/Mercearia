/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import br.edu.ifnmg.Mercearia.DomainModel.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Larisse
 */
public class UsuarioRepositorio extends BancoDados {
    
    public UsuarioRepositorio(){
        super();
    }
    
    public boolean  Salvar(Usuario obj){
        
        try{
            if(obj.getId()==0){
                PreparedStatement sql = this.getConexao()
                        .prepareStatement("insert into Usuario(cpf, senha) values(?,?)");
                sql.setString(1, obj.getCpf());
                sql.setString(2, obj.getSenha());
                
                if(sql.executeUpdate()>0){
                    return true;
                }else
                    return true;
               
            }else{
                if(obj.getId()==0){
                    PreparedStatement sql = this.getConexao()
                            .prepareStatement("update  Usuario set cpf =?, senha=? where id = ?");
                    sql.setString(1, obj.getCpf());
                    sql.setString(2, obj.getSenha());

                    if(sql.executeUpdate()>0){
                        return true;
                    }else
                        return true;
                }
            }

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public Usuario Abrir(int id){
        try{
            PreparedStatement sql = this.getConexao()
                    .prepareStatement("select * from Usuario where id=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            resultado.next();
            Usuario usuario = new Usuario();
            
            usuario.setId(resultado.getInt("id"));
            usuario.setCpf(resultado.getString("cpf"));
            usuario.setSenha(resultado.getString("senha"));
            
            return usuario;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    } 
    
}
