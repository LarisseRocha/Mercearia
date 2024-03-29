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
public class Venda {
    private int id; 
    private float valorTotal;
    Date dtVenda;
    private String operador;
    private Cliente cliente;

    public Venda(int id, float valorTotal, Date dtVenda, String operador) {
        this.id = 0;
        this.valorTotal = 0;
        this.dtVenda = dtVenda;
        this.operador = "";
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

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

   
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Float.floatToIntBits(this.valorTotal);
        hash = 31 * hash + Objects.hashCode(this.dtVenda);
        hash = 31 * hash + Objects.hashCode(this.operador);
        hash = 31 * hash + Objects.hashCode(this.cliente);
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
        final Venda other = (Venda) obj;
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
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return "Venda{" + "id=" + id + ", valorTotal=" + valorTotal + ", dtVenda=" + dtVenda + ", operador=" + operador + ", cliente=" + cliente + '}';
    }


   
    

    
}
