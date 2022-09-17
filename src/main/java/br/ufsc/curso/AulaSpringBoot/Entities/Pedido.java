/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author RC_Ventura 
 */
@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
   
//atributos 
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;     
    private Instant data;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoProduto> produtos = new HashSet<>();
    
// construtores

    public Pedido(){}
    
    public Pedido(Long id, Instant data) {
        this.id = id;
        this.data = data;
    }

//metodos padroes

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<PedidoProduto> getProdutos() {
        return produtos;
    }

    public Double getTotalPedido(){
        Double total = 0d;
        for (PedidoProduto p: produtos){
             total = total + p.getSubTotal();
        } return total;
        
    }
    

     
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
