/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.DomainModel;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author Larisse
 */
public class Compra {
     private int id; 
     private float valorTotal;
     Date dtVenda;
     private String operador;
     private Fornecedor fornecedor ;

    public Compra(int id, float valorTotal, Date dtVenda,  Fornecedor fornecedor) {
        this.id = 0;
        this.valorTotal = 0;
        this.dtVenda = dtVenda;
        this.operador = "";
        this.fornecedor = fornecedor;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Float.floatToIntBits(this.valorTotal);
        hash = 53 * hash + Objects.hashCode(this.dtVenda);
        hash = 53 * hash + Objects.hashCode(this.operador);
        hash = 53 * hash + Objects.hashCode(this.fornecedor);
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
        if (!Objects.equals(this.operador, other.operador)) {
            return false;
        }
        if (!Objects.equals(this.dtVenda, other.dtVenda)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", valorTotal=" + valorTotal + ", dtVenda=" + dtVenda + ", operador=" + operador + ", fornecedor=" + fornecedor + '}';
    }
    

   

   

}
