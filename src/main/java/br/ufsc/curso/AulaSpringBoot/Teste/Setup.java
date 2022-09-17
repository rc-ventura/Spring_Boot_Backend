/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Teste;

import br.ufsc.curso.AulaSpringBoot.Entities.Categoria;
import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Entities.Endereco;
import br.ufsc.curso.AulaSpringBoot.Entities.Pedido;
import br.ufsc.curso.AulaSpringBoot.Entities.PedidoProduto;
import br.ufsc.curso.AulaSpringBoot.Entities.Produto;
import br.ufsc.curso.AulaSpringBoot.Repositories.CategoriaRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.ClienteRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.EnderecoRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.PedidoProdutoRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.PedidoRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.ProdutoRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author RC_Ventura
 */

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner {

    // dependency injection
    @Autowired
    private ClienteRepository clienteRepository;  // posso colocar Autowired para uma injeção ou criar um construtor
   
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;
   
    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;
    
    
    @Override
    public void run(String... args) throws Exception {
        
        //adicionando clientes
        Cliente c1 = new Cliente (null, "Joao da Silva", "joao@gmail.com", "9999999", "123mudar" );
        Cliente c2 = new Cliente (null, "Maria dos Santos", "Maria@gmail.com", "777777", "123mudar" );
        Cliente c3 = new Cliente (null, "Ana Paula Ferreira", "Ana@gmail.com", "66666", "123mudar" );
        
        //adicionando enderecos
        Endereco end1 = new Endereco( null, "rua", "Buganvilias", "123", "88056025", c1);
        Endereco end2 = new Endereco( null, "avenida", "Carlos Chagas", "100", "80050605", c2);
        Endereco end3 = new Endereco( null, "travessa", " Oge Fortkamp", "001", "35035000", c2);
        Endereco end4 = new Endereco( null, "avenida", "Camanducaia", "50", "50050000", c3);

       //salvando os registros clientes e enderecos
       
        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
        
        enderecoRepository.saveAll(Arrays.asList(end1,end2,end3,end4));
        
        //adicionando produtos
       
        Produto p1 = new Produto (null, "Pasta de Dente", 5.0d , 100.0d);
        Produto p2 = new Produto (null, "Alcool", 12.0d , 10.0d);
        Produto p3 = new Produto (null, "Detergente", 2.75d , 1000.0d);
        Produto p4 = new Produto (null, "Toalha", 8.0d , 20.0d);
        Produto p5 = new Produto (null, "Vela", 0.25d , 10000.0d);

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5)); // salvando os registros em produto
    
        //adicionando categorias 
        
        Categoria cat1 = new Categoria (null, "Roupa e Banho");
        Categoria cat2 = new Categoria (null, "Limpeza");
        Categoria cat3 = new Categoria (null, "Iluminacao");
        Categoria cat4 = new Categoria (null, "Higiene");
        Categoria cat5 = new Categoria (null, "Cama, Mesa e Banho");
    
      
       categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5)); //salvando os registris em categoria
       
       //criando uma associacao produto com categoria
       
       p1.getCategorias().add(cat1);
       p1.getCategorias().add(cat2);
       p1.getCategorias().add(cat4);
       p2.getCategorias().add(cat1);
       p2.getCategorias().add(cat2);
       p2.getCategorias().add(cat4);
       p3.getCategorias().add(cat2);
       p3.getCategorias().add(cat4);
       p4.getCategorias().add(cat1);
       p4.getCategorias().add(cat5);
       p5.getCategorias().add(cat3);
       
       produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5)); //salvando os registros relacionais
       
      //adicionando pedidos
      
      Pedido ped1 = new Pedido (null, Instant.parse("2019-06-20T19:53:07Z"));
      Pedido ped2 = new Pedido (null, Instant.parse("2020-06-20T19:53:07Z"));
      Pedido ped3 = new Pedido (null, Instant.parse("2021-06-20T19:53:07Z"));

      pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3));
      
      // associando cada pedido com um cliente 
      
      ped1.setCliente(c1);
      ped2.setCliente(c2);
      ped3.setCliente(c3);
      
      pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3));
      
      // associando cada pedido com um produto 
      
      PedidoProduto pp1 = new PedidoProduto ( ped1, p1, 10d, 25.5d);
      PedidoProduto pp2 = new PedidoProduto ( ped1, p2, 8d, 35.5d);
      PedidoProduto pp3 = new PedidoProduto ( ped2, p1, 12d, 25.5d);
      PedidoProduto pp4 = new PedidoProduto ( ped2, p3, 3d, 5.45d);
      PedidoProduto pp5 = new PedidoProduto ( ped2, p4, 1d, 9.0d);
      
      pedidoProdutoRepository.saveAll(Arrays.asList(pp1,pp2,pp3,pp4,pp5));
      
}
    
}
