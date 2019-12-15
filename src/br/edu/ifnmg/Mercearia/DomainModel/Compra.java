/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Larisse
 */
public class Compra {
     private int id; 
     private float valorTotal;
     private int quantidade;
     //Date dtVenda;
    // private String operador;
     private Fornecedor fornecedor ;
     public List<Produto> produtos;

    public Compra(int id, float valorTotal, int quantidade, Date dtVenda, String operador, Fornecedor fornecedor, Produto produto) {
        this.id = 0;
        this.valorTotal = 0;
       // this.dtVenda = dtVenda;
        //this.operador = "";
        this.fornecedor = fornecedor;
        this.quantidade = 0;
        this.produtos = new ArrayList<Produto>();
    }

   

    public Compra() {
        this.produtos = new ArrayList<Produto>();
        this.id = 0;
        this.valorTotal = 0;
       // this.dtVenda = dtVenda;
        //this.operador = "";
        this.quantidade = 0;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

   /* public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }*/
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

   /* public String getOperador() {
         return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }*/

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


 

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", valorTotal=" + valorTotal + ", quantidade=" + quantidade + ", fornecedor=" + fornecedor + ", produtos=" + produtos + '}';
    }

   



    
    public List<Produto> getProdutos() {
         return this.produtos;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addProduto(Produto produto, int quantidade) {
        this.produtos.add(produto);
        this.valorTotal+= produto.getPrCompra()*quantidade;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}
