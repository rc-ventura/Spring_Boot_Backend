/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Controllers;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Services.ClienteService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    @PostMapping(value = "/clientes")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente savedCliente = clienteService.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("/clientes/{id}").buildAndExpand(savedCliente.getId()).toUri();
        return ResponseEntity.created(uri).body(savedCliente);
    }
    
    
    @DeleteMapping(value = "/clientes/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
        
    }
    
    @PutMapping(value = "/clientes/{id}")
    public ResponseEntity<Cliente> update (@PathVariable Long id, @RequestBody Cliente cliente){ 
    cliente = clienteService.update(id, cliente);
    return ResponseEntity.ok().body(cliente);
}
    
}