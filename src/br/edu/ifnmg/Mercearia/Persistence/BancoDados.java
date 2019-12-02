/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Larisse
 */
public class BancoDados {
    private Connection conexao;
    public BancoDados(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Mercearia","root","root");
        }catch(ClassNotFoundException ex){
            System.out.println("Driver do banco de dados não encontrado");
        }catch(SQLException ex){
            System.out.println("Os dados de conexão com o banco de dados estão errados"); 
            System.out.println(ex.getMessage());
        }              
        
        
        
     }
   public Connection getConexao(){
            return conexao;
    }
}
    
