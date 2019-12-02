/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Presentation.Console;

import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Mercearia.DomainModel.Estado;
import br.edu.ifnmg.Mercearia.DomainModel.Fornecedor;
import br.edu.ifnmg.Mercearia.DomainModel.Produto;
import br.edu.ifnmg.Mercearia.DomainModel.Situacao;
import br.edu.ifnmg.Mercearia.DomainModel.Usuario;
import br.edu.ifnmg.Mercearia.Persistence.ClienteRepositorio;
import br.edu.ifnmg.Mercearia.Persistence.FornecedorRepositorio;
import br.edu.ifnmg.Mercearia.Persistence.ProdutoRepositorio;
import br.edu.ifnmg.Mercearia.Persistence.UsuarioRepositorio;

/**
 *
 * @author Larisse
 */
public class Mercearia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ErroValidacaoException {
        // TODO code application logic here
            Cliente a2 = new Cliente();
            a2.setNome("Larisse");
            a2.setCpf("111.111.111-20");
            a2.setNumero("1");
            a2.setRua("av. A");
            a2.setEmail("aaa@mail.com");
            a2.setBairro("Centro");
            a2.setCidade("Januária");
            a2.setEstado(Estado.AC);
            a2.setSituacao(Situacao.ATIVO);
            
            ClienteRepositorio repo = new ClienteRepositorio();
            repo.Salvar(a2);
            
            
            Fornecedor f = new Fornecedor();
            f.setCnpj("00.000.000.0000/02");
            f.setRazaoSocial("Variados");
            f.setEmail("variado@mail.com");
            f.setRua("Rua B");
            f.setNumero("12");
            f.setBairro("Limoeiro");
            f.setCidade("Januaaria");
            f.setEstado("MG");
            f.setSituacao(Situacao.ATIVO);
            
            FornecedorRepositorio repF = new FornecedorRepositorio();
            repF.Salvar(f);
            
            
            
            
            
            Usuario u = new Usuario();
            u.setCpf("00000000001");
            u.setSenha("123");
            
            UsuarioRepositorio rep = new UsuarioRepositorio();
            rep.Salvar(u);
            
            
            Produto p = new Produto();
            p.setDescricao("Café");
            p.setPrCompra((float) 2.50);
            p.setPrVenda((float) 3.00);
            p.setUniCompra(12);
            p.setUniVenda(12);
            
            ProdutoRepositorio repP = new ProdutoRepositorio();
            repP.Salvar(p);
            
    }
    
}
