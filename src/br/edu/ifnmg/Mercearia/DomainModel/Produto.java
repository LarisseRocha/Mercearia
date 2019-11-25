/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.DomainModel;

import java.util.Objects;

/**
 *
 * @author Larisse
 */
public class Produto {
    private int id;
    private String descricao;
    private float uniCompra;
    private float uniVenda;
    private float prCompra;
    private float prVenda;
    private Fornecedor fornecedor;

    public Produto(int id, String descricao, float uniCompra, float uniVenda, float prCompra, float prVenda, Fornecedor fornecedor) {
        this.id = id;
        this.descricao = "";
        this.uniCompra = 0;
        this.uniVenda = 0;
        this.prCompra = 0;
        this.prVenda = 0;
        this.fornecedor = fornecedor;
    }

    public Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getUniCompra() {
        return uniCompra;
    }

    public void setUniCompra(float uniCompra) {
        this.uniCompra = uniCompra;
    }

    public float getUniVenda() {
        return uniVenda;
    }

    public void setUniVenda(float uniVenda) {
        this.uniVenda = uniVenda;
    }

    public float getPrCompra() {
        return prCompra;
    }

    public void setPrCompra(float prCompra) {
        this.prCompra = prCompra;
    }

    public float getPrVenda() {
        return prVenda;
    }

    public void setPrVenda(float prVenda) {
        this.prVenda = prVenda;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + Float.floatToIntBits(this.uniCompra);
        hash = 97 * hash + Float.floatToIntBits(this.uniVenda);
        hash = 97 * hash + Float.floatToIntBits(this.prCompra);
        hash = 97 * hash + Float.floatToIntBits(this.prVenda);
        hash = 97 * hash + Objects.hashCode(this.fornecedor);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.uniCompra) != Float.floatToIntBits(other.uniCompra)) {
            return false;
        }
        if (Float.floatToIntBits(this.uniVenda) != Float.floatToIntBits(other.uniVenda)) {
            return false;
        }
        if (Float.floatToIntBits(this.prCompra) != Float.floatToIntBits(other.prCompra)) {
            return false;
        }
        if (Float.floatToIntBits(this.prVenda) != Float.floatToIntBits(other.prVenda)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", uniCompra=" + uniCompra + ", uniVenda=" + uniVenda + ", prCompra=" + prCompra + ", prVenda=" + prVenda + ", fornecedor=" + fornecedor + '}';
    }
    
}
