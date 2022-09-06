/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Controllers;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RC_Ve
 */

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    
    @GetMapping(value = "/clientes")
    public ResponseEntity<List<Cliente>> findAll(){
    
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(clientes);
}

    @GetMapping(value = "/clientes/{id}")
    public ResponseEntity <Cliente> findById(@PathVariable Long id){
        Cliente c = clienteService.findById(id);
        return ResponseEntity.ok().body(c);

        
    }
    
}