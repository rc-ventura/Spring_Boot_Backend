/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Controllers;

import br.ufsc.curso.AulaSpringBoot.Entities.Categoria;
import br.ufsc.curso.AulaSpringBoot.Services.CategoriaService;
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
 * @author RC_Ventura
 */
@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping(value = "/categorias")
    public ResponseEntity<List<Categoria>> findAll(){
       List<Categoria> categorias = categoriaService.findAll();
       return ResponseEntity.ok().body(categorias);
    }
    
    @GetMapping(value = "/categorias/{id}")
    public ResponseEntity<Categoria> findById(Long id){
        Categoria categorias = categoriaService.findById(id);
        return ResponseEntity.ok().body(categorias);
    }
    
    @PostMapping(value = "/categorias")
    public ResponseEntity<Categoria> save (@RequestBody Categoria categoria){
        Categoria savedCategoria = categoriaService.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/categorias/{id}")
        .buildAndExpand(savedCategoria.getId()).toUri();
        return ResponseEntity.created(uri).body(savedCategoria);
    
    }

    
    @DeleteMapping(value = "/categorias/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
         categoriaService.delete(id);
         return ResponseEntity.noContent().build();
    }
 
    @PutMapping(value = "categorias/{id}")
    public ResponseEntity<Categoria> update (@PathVariable Long id, @RequestBody Categoria categoria){
        categoria = categoriaService.update(id, categoria);
        return ResponseEntity.ok().body(categoria);
    }
    
    
}
    

    
    


    