/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.DomainModel;

import java.util.ArrayList;
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
    private String numero;
    private String bairro;
    private String cidade;
    private Estado estado;
    private Situacao situacao;
   // private Produto produto;
    
    private Pattern regex_cnpj = Pattern.compile("\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}");

    
      public Fornecedor() {
        this.id = 0;
        this.cnpj = "00.000.000/0000-00";
        this.razaoSocial = "";
        this.email = "";
        this.telefones = new ArrayList<>();
        this.rua = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = Estado.AC;
        this.situacao = Situacao.ATIVO;
        //this.produto = produto;
       
    }
    public Fornecedor(int id, String cnpj, String razaoSocial, String email, List<String> telefones, String rua, String numero, String bairro, String cidade, String estado, boolean situacao, Produto produto) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefones = new ArrayList<>();
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = Estado.AC;
        this.situacao = Situacao.ATIVO;
       //this.produto = produto;
    }
 

    public String getCnpj() {
        return cnpj.substring(0, 2)+"."+
               cnpj.substring(2, 5)+"."+
               cnpj.substring(5, 8)+"/"+
               cnpj.substring(8, 12)+"-"+
               cnpj.substring(12, 14);
                            
    }
    

     public void setCnpj(String cnpj) throws ErroValidacaoException {
        Matcher m = regex_cnpj.matcher(cnpj);
        if(m.matches())
            this.cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
        else
            throw new ErroValidacaoException("CNPJ Inválido!");
    }
     
    
    
   public int getId() {
        return id;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int aInt) {
       id = aInt;
    }
    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
    
    
    public void addTelefone(String telefone){
        if(!this.telefones.contains(telefone))
            this.telefones.add(telefone);
    }
    
    public void removeTelefone(String telefone){
        if(!this.telefones.contains(telefone))
            this.telefones.remove(telefone);
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    

    /*public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.cnpj);
        hash = 79 * hash + Objects.hashCode(this.razaoSocial);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.telefones);
        hash = 79 * hash + Objects.hashCode(this.rua);
        hash = 79 * hash + Objects.hashCode(this.numero);
        hash = 79 * hash + Objects.hashCode(this.bairro);
        hash = 79 * hash + Objects.hashCode(this.cidade);
        hash = 79 * hash + Objects.hashCode(this.estado);
        hash = 79 * hash + Objects.hashCode(this.situacao);
        hash = 79 * hash + Objects.hashCode(this.regex_cnpj);
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
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.situacao != other.situacao) {
            return false;
        }
        if (!Objects.equals(this.regex_cnpj, other.regex_cnpj)) {
            return false;
        }
        return true;
    }

   /* @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", email=" + email + ", telefones=" + telefones + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", situacao=" + situacao + ", regex_cnpj=" + regex_cnpj + '}';
    }*/

    @Override
    public String toString() {
        return razaoSocial;
    }
    

    

    public void setEstado(String mg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    
}
