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
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    public List<String>telefones;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private Estado estado;
    private Situacao situacao;
    
    Pattern  regex_cpf = Pattern.compile("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}");

    public Cliente(int id, String nome, String cpf, String email, List<String> telefones, String rua, String numero, String bairro, String cidade, Estado estado, Situacao situacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = new ArrayList<>();
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = bairro;
        this.estado = estado;
        this.situacao = situacao;
    }
    
      public Cliente() {
        this.nome = "";
        this.cpf = "000.000.000-00";
        this.email = "";
        this.telefones = new ArrayList<>();
        this.rua = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = Estado.AC;
        this.situacao = Situacao.ATIVO;
    }


    public int getId() {
        return id;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(int id) {
         this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf.substring(0, 3)+"."+
               cpf.substring(3, 6)+"."+
               cpf.substring(6, 9)+"-"+
               cpf.substring(9, 11);
    }

    public void setCpf(String cpf) throws ErroValidacaoException {
        Matcher v = regex_cpf.matcher(cpf);
        if(v.matches())
            this.cpf = cpf.replace(".","").replace("-","");
        else
            throw new ErroValidacaoException("CPF inválido");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.cpf);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.telefones);
        hash = 23 * hash + Objects.hashCode(this.rua);
        hash = 23 * hash + Objects.hashCode(this.numero);
        hash = 23 * hash + Objects.hashCode(this.bairro);
        hash = 23 * hash + Objects.hashCode(this.cidade);
        hash = 23 * hash + Objects.hashCode(this.estado);
        hash = 23 * hash + Objects.hashCode(this.situacao);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
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
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefones=" + telefones + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", situacao=" + situacao + '}';
    }

  

   
   
    public void getCliente() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    

    
    
}
