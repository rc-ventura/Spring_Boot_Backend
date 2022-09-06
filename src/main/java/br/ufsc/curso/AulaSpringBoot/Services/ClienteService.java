/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Services;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Repositories.ClienteRepository;
import java.util.List;
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
        return clienteRepository.findById(id).get();
    }
}
