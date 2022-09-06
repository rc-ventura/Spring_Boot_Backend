/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Controllers;

import br.ufsc.curso.AulaSpringBoot.Entities.Endereco;
import br.ufsc.curso.AulaSpringBoot.Services.EnderecoService;
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
}
