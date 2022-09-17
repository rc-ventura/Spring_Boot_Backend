/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Services;

import br.ufsc.curso.AulaSpringBoot.Entities.Pedido;
import br.ufsc.curso.AulaSpringBoot.Repositories.PedidoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class PedidoService {
    
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    
    public List <Pedido> findAll(){
        return pedidoRepository.findAll();
    }
    
    public Pedido findById (Long id){
        try{
            
                return pedidoRepository.findById(id).get();
        }catch (NoSuchElementException e) {
            throw new EntityNotFoundException(" EntityNotFoundException Pedido id: " + id);
        }
    }
    
    
    public Pedido save (Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    
    
    public void delete (Long id){
        pedidoRepository.deleteById(id);
    }
    
    public Pedido update (Long id, Pedido pedido){
        Pedido pedidoEntity = pedidoRepository.getReferenceById(id);
        pedidoEntity.setData(pedido.getData());
        return pedidoRepository.save(pedidoEntity);

    }
           
} 
    

