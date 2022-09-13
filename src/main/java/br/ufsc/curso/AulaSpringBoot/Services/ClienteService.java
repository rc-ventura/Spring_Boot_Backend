/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Services;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Repositories.ClienteRepository;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ve
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List <Cliente> findAll(){
        return clienteRepository.findAll();
    }
    
    public Cliente findById(Long id){
        try{
             return clienteRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(" EntityNotFoundException Cliente id: " + id);
        }
    }
        
    
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public void delete (Long id){
        clienteRepository.deleteById(id);
    }
    
    public Cliente update (Long id, Cliente cliente){
        Cliente clienteEntity = clienteRepository.getReferenceById(id);
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setFone(cliente.getFone());
        clienteEntity.setSenha(cliente.getSenha());
        return clienteRepository.save(clienteEntity);

     
        }
    }
        
        
        
    
    

