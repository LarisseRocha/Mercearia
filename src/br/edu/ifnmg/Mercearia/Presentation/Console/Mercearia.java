/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Mercearia.Presentation.Console;

import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.Persistence.ClienteRepositorio;

/**
 *
 * @author Larisse
 */
public class Mercearia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Cliente c1 = new Cliente();
            c1.setNome("Larisse");
            c1.setCpf("123.111.111-20");
      
      
            ClienteRepositorio repo = new ClienteRepositorio();
            repo.Salvar(c1);
    }
    
}
