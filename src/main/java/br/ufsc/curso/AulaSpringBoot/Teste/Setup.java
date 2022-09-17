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


@Configuration
@Profile("test")
public class Setup implements CommandLineRunner{
	
	// dependency injection
	@Autowired
	private ClienteRepository clienteRepository; 
	
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
		Cliente c1 = new Cliente(null, "João da Silva", "joao@gmail.com", "99999999999", "123mudar");
		Cliente c2 = new Cliente(null, "Maria dos Santos", "maria@m.com", "88888888888", "123mudar");
		Cliente c3 = new Cliente(null, "Ana Paula Ferreira", "ana@gmail.com", "77777777777", "123mudar");
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Endereco e1 = new Endereco(null, "casa", "Rua das Palmeiras", "333", "89.001-001", c1);
		Endereco e2 = new Endereco(null, "trabalho", "Rua dos Coqueiros", "222", "89.222-001", c1);
		Endereco e3 = new Endereco(null, "casa", "Rua das Rosas", "111", "91.002-004", c2);
		Endereco e4 = new Endereco(null, "sitio", "Rua dos Cravos", "34", "89.003-007", c2);
		Endereco e5 = new Endereco(null, "trabalho", "Rua das Laranjeiras", "1234", "90.001-001", c3);
		Endereco e6 = new Endereco(null, "trabalho", "Rua das Laranjeiras", "1234", "90.001-001", null);
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));		
		
		
		Produto p1 = new Produto(null, "Produto 1", 10d, 25.5);
		Produto p2 = new Produto(null, "Produto 2", 33d, 66d);
		Produto p3 = new Produto(null, "Produto 3", 21.10d, 32.5);
		Produto p4 = new Produto(null, "Produto 4", 12d, 25d);
		Produto p5 = new Produto(null, "Produto 5", 1000d, 5.2);
		Produto p6 = new Produto(null, "Produto 6", 300d, 86.3);
				
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
			
		Categoria ca1 = new Categoria(null, "Categoria 1");
		Categoria ca2 = new Categoria(null, "Categoria 2");
		Categoria ca3 = new Categoria(null, "Categoria 3");
		Categoria ca4 = new Categoria(null, "Categoria 4");
		Categoria ca5 = new Categoria(null, "Categoria 5");
		Categoria ca6 = new Categoria(null, "Categoria 6");
		Categoria ca7 = new Categoria(null, "Categoria 7");
				
		categoriaRepository.saveAll(Arrays.asList(ca1, ca2, ca3, ca4, ca5, ca6, ca7));
				
			
		p1.getCategorias().add(ca1);
		p1.getCategorias().add(ca2);
		p1.getCategorias().add(ca3);
		p2.getCategorias().add(ca2);
		p2.getCategorias().add(ca3);
		p3.getCategorias().add(ca3);
		p3.getCategorias().add(ca4);
		p4.getCategorias().add(ca3);
		p4.getCategorias().add(ca4);		
		p5.getCategorias().add(ca5);
		p5.getCategorias().add(ca6);
		p6.getCategorias().add(ca7);					
				
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		// pedidos
		Pedido pe1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"));
		Pedido pe2 = new Pedido(null, Instant.parse("2020-06-20T19:53:07Z"));
		Pedido pe3 = new Pedido(null, Instant.parse("2021-06-20T19:53:07Z"));				
		pedidoRepository.saveAll(Arrays.asList(pe1, pe2, pe3));
				
		
		// associando um cliente com cada pedido 
		pe1.setCliente(c1);
		pe2.setCliente(c2);
		pe3.setCliente(c3);		
		pedidoRepository.saveAll(Arrays.asList(pe1, pe2, pe3));

		
		// inserindo produtos no pedido
		PedidoProduto pp1 = new PedidoProduto(pe1, p1, 10d, 25.5d);
		PedidoProduto pp2 = new PedidoProduto(pe1, p2, 8d, 35.5d);
					
		PedidoProduto pp3 = new PedidoProduto(pe2, p1, 12d, 25.5d);
		PedidoProduto pp4 = new PedidoProduto(pe2, p3, 3d, 5.45d);
		PedidoProduto pp5 = new PedidoProduto(pe2, p4, 1d, 9.0d);
				
		pedidoProdutoRepository.saveAll(Arrays.asList(pp1, pp2, pp3, pp4, pp5));
		
		
	}

}
