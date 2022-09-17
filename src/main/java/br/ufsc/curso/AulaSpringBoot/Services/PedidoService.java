package br.ufsc.curso.AulaSpringBoot.services;

import br.ufsc.curso.AulaSpringBoot.Entities.Pedido;
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
