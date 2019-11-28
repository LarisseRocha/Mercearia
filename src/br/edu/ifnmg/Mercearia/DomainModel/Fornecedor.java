/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.DomainModel;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Larisse
 */
public class Fornecedor {
    private int id;
    private String cnpj;
    private String razaoSocial;
    private String email;
    private List<String> telefones;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private boolean situacao;
    private Produto produto;
    
    Pattern regex_cnpj = Pattern.compile("\\d{2}\\.?\\{3}\\.?{3}\\/?\\{4}-?\\{2}");
    private Object cnpj_regex;
                                           

    public Fornecedor(int cnpj, String razaoSocial, String email, String rua, int numero, String bairro, String cidade, String estado) {
        this.cnpj = "";
        this.razaoSocial = "";
        this.email = "";
        this.rua = "";
        this.numero = 0;
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.situacao = true;
        this.produto = produto;
    }

    public Fornecedor() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCnpj() {
        return cnpj.substring(0, 2)+"."+
               cnpj.substring(2, 5)+"."+
               cnpj.substring(5, 8)+"/"+
               cnpj.substring(8, 12)+"-"+
               cnpj.substring(12, 14);
                            
    }
    

    public void setCnpj(String cnpj) {
        Matcher v = regex_cnpj.matcher(cnpj);
        if(v.matches())
           this.cnpj = cnpj.replace(".","").replace("-","").replace("/","");
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        
            this.telefones = telefones;
    }

   

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.cnpj);
        hash = 31 * hash + Objects.hashCode(this.razaoSocial);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.telefones);
        hash = 31 * hash + Objects.hashCode(this.rua);
        hash = 31 * hash + this.numero;
        hash = 31 * hash + Objects.hashCode(this.bairro);
        hash = 31 * hash + Objects.hashCode(this.cidade);
        hash = 31 * hash + Objects.hashCode(this.estado);
        hash = 31 * hash + (this.situacao ? 1 : 0);
        hash = 31 * hash + Objects.hashCode(this.produto);
        hash = 31 * hash + Objects.hashCode(this.cnpj_regex);
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.situacao != other.situacao) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.razaoSocial, other.razaoSocial)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.cnpj_regex, other.cnpj_regex)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", email=" + email + ", telefones=" + telefones + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", situacao=" + situacao + ", produto=" + produto + ", cnpj_regex=" + cnpj_regex + '}';
    }
    
        public int getId() {
        return 0;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int aInt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
