/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.ufsc.curso.AulaSpringBoot.Controllers;


import br.ufsc.curso.AulaSpringBoot.Entities.Pedido;
import br.ufsc.curso.AulaSpringBoot.services.PedidoService;
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
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    
    @GetMapping(value = "/pedidos")
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidos);
}

    @GetMapping(value = "/pedidos/{id}")
    public ResponseEntity <Pedido> findById(@PathVariable Long id){
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);

        
    }
    
    @PostMapping(value = "/pedidos")
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        Pedido savedPedido= pedidoService.save(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path
        ("/pedidos/{id}").buildAndExpand(savedPedido.getId()).toUri();
        return ResponseEntity.created(uri).body(savedPedido);
    }
    
    
    @DeleteMapping(value = "/pedidos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }
    
    @PutMapping(value = "/pedidos/{id}")
    public ResponseEntity<Pedido> update (@PathVariable Long id, @RequestBody Pedido pedido){ 
        pedido = pedidoService.update(id, pedido);
        return ResponseEntity.ok().body(pedido);
}
    
            
}

   
   