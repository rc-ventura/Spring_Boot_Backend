/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Controllers;

import br.ufsc.curso.AulaSpringBoot.Entities.Endereco;
import br.ufsc.curso.AulaSpringBoot.Services.EnderecoService;
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
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @GetMapping(value = "/enderecos")
    public ResponseEntity<List<Endereco>> findAll (){
        List<Endereco> enderecos = enderecoService.findAll();
        return ResponseEntity.ok().body(enderecos);
    }
    
    @GetMapping(value = "/enderecos/{id}")
    public ResponseEntity <Endereco> findById (@PathVariable Long id){
        Endereco end = enderecoService.findById(id);
        return ResponseEntity.ok().body(end);
    }
    
    @PostMapping(value = "/enderecos")
    public ResponseEntity<Endereco> save(@RequestBody Endereco end) {
        Endereco savedEndereco = enderecoService.save(end);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("/enderecos/{id}").buildAndExpand(savedEndereco.getId()).toUri();
        return ResponseEntity.created(uri).body(savedEndereco);
    }
        
    @DeleteMapping(value = "/enderecos/{id}") 
    public ResponseEntity<Void> delete(@PathVariable long id){
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping(value = "/enderecos/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco end){
       end = enderecoService.update(id, end);
       return ResponseEntity.ok().body(end);
   
        
    }
        
        
        
    }
    

