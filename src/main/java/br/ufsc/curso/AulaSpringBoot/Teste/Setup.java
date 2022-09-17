/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Teste;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Entities.Endereco;
import br.ufsc.curso.AulaSpringBoot.Repositories.ClienteRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.EnderecoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author RC_Ve
 */

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner {

    // dependency injection
    @Autowired
    private ClienteRepository clienteRepository;  // posso colocar Autowired para uma injeção ou criar um construtor
    @Autowired
    private EnderecoRepository enderecoRepository;
   
    
    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente (null, "Joao da Silva", "joao@gmail.com", "9999999", "123mudar" );
        Cliente c2 = new Cliente (null, "Maria dos Santos", "Maria@gmail.com", "777777", "123mudar" );
        Cliente c3 = new Cliente (null, "Ana Paula Ferreira", "Ana@gmail.com", "66666", "123mudar" );
        
        Endereco end1 = new Endereco( null, "rua", "Buganvilias", "123", "88056025");
        Endereco end2 = new Endereco( null, "avenida", "Carlos Chagas", "100", "80050605");

       
        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
        
        enderecoRepository.saveAll(Arrays.asList(end1,end2));

    }
    
}
