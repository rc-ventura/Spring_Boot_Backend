/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Controllers;

import br.ufsc.curso.AulaSpringBoot.Entities.Produto;
import br.ufsc.curso.AulaSpringBoot.Services.ProdutoService;
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
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    
    @GetMapping(value = "/produtos")
    public ResponseEntity<List<Produto>> findAll(){
       List<Produto> produtos = produtoService.findAll();
       return ResponseEntity.ok().body(produtos);
    }
    
    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<Produto> findById(Long id){
        Produto produtos = produtoService.findById(id);
        return ResponseEntity.ok().body(produtos);
    }
    
    @PostMapping(value = "/produtos")
    public ResponseEntity<Produto> save (@RequestBody Produto produto){
        Produto savedProduto = produtoService.save(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}")
        .buildAndExpand(savedProduto.getId()).toUri();
        return ResponseEntity.created(uri).body(savedProduto);
    
    }

    
    @DeleteMapping(value = "/produtos/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
         produtoService.delete(id);
         return ResponseEntity.noContent().build();
    }
 
    @PutMapping(value = "produtos/{id}")
    public ResponseEntity<Produto> update (@PathVariable Long id, @RequestBody Produto produto){
        produto = produtoService.update(id, produto);
        return ResponseEntity.ok().body(produto);
   
    }
    
    @PutMapping(value = "/produtos/{id_produto}/addCategoria/{id_categoria}")
    public ResponseEntity<Produto> addCategoria (@PathVariable Long id_produto,@PathVariable Long id_categoria){
         Produto produto = produtoService.addCategoria(id_produto, id_categoria);
         return ResponseEntity.ok().body(produto);
        
    }
    
    @DeleteMapping( value = "/produtos/{id_produto}/removeCategoria/{id_categoria}")
    public ResponseEntity<Produto> removeCategoria (@PathVariable Long id_produto,
            @PathVariable Long id_categoria){
        Produto produto = produtoService.removeCategoria(id_produto, id_categoria);
        return ResponseEntity.ok().body(produto);
    }
}
    

    
    


    