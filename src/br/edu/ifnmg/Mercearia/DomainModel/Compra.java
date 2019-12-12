/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.DomainModel;

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
     Date dtVenda;
     private String operador;
     private Fornecedor fornecedor ;
    public Produto produto;

    public Compra(int id, float valorTotal, int quantidade, Date dtVenda, String operador, Fornecedor fornecedor, Produto produto) {
        this.id = 0;
        this.valorTotal = 0;
        this.dtVenda = dtVenda;
        this.operador = "";
        this.fornecedor = fornecedor;
        this.quantidade = 0;
        this.produto = produto;
    }

   

    public Compra() {
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

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getOperador() {
         return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Float.floatToIntBits(this.valorTotal);
        hash = 41 * hash + this.quantidade;
        hash = 41 * hash + Objects.hashCode(this.dtVenda);
        hash = 41 * hash + Objects.hashCode(this.operador);
        hash = 41 * hash + Objects.hashCode(this.fornecedor);
        hash = 41 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valorTotal) != Float.floatToIntBits(other.valorTotal)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.operador, other.operador)) {
            return false;
        }
        if (!Objects.equals(this.dtVenda, other.dtVenda)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", valorTotal=" + valorTotal + ", quantidade=" + quantidade + ", dtVenda=" + dtVenda + ", operador=" + operador + ", fornecedor=" + fornecedor + ", produto=" + produto + '}';
    }

    public List<Produto> getProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}
