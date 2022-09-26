package br.ufsc.curso.AulaSpringBoot.services;

import br.ufsc.curso.AulaSpringBoot.Entities.Pedido;
import br.ufsc.curso.AulaSpringBoot.Entities.PedidoProduto;
import br.ufsc.curso.AulaSpringBoot.Repositories.PedidoProdutoRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.PedidoRepository;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository; 
        
        @Autowired
	private PedidoProdutoRepository pedidoProdutoRepository; 
	
	
	
	public Pedido update(Long id, Pedido pedido) {
		Pedido pedidoEntity = pedidoRepository.getReferenceById(id);
		
		pedidoEntity.setData(pedido.getData());
		
		return pedidoRepository.save(pedidoEntity);		
	}
	
	
	public void deleteById(Long id) {
		//try {
			pedidoRepository.deleteById(id);
		//}catch (RuntimeException e) {
		//	e.printStackTrace();
		//}
		
	}
	// Fazer um pedido completo - mandar no corpo todos os dados de um pedido (Pedido : Produto) 
        // Quais produtos fazem parte de cada pedido

        public Pedido saveFull(Pedido pedido){
        
        //salvar o produto [gerar id ao pedido]
        Pedido savedPedido = pedidoRepository.save(pedido);
        
        //associar qual o id do pedido para cada produto
        
        for(PedidoProduto pp: pedido.getProdutos()){
            pp.setPedido(savedPedido);
        }
         // salvar os produtos
         pedidoProdutoRepository.saveAll(pedido.getProdutos());
         return findById(savedPedido.getId());
         
        }
        
    

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}

	public Pedido findById(Long id) {		
		try {
			return pedidoRepository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("EntityNotFoundException Pedido id: " + id);
		}
	}
	
}
