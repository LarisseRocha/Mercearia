/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Presentation.Console;

import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
import br.edu.ifnmg.Mercearia.DomainModel.Cliente;
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
          Cliente a2 = new Cliente();
            a2.setNome("Larisse");
            a2.setCpf("123.111.111-20");
      
      
            ClienteRepositorio repo = new ClienteRepositorio();
            repo.Salvar(a2);
    }
    
}
