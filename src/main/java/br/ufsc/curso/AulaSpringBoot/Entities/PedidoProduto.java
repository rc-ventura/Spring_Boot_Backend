/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author RC_Ventura
 */
@Entity
public class PedidoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //metaclass (nova classe para uma chave composta dentro de uma classe)
    
    @Embeddable
    public static class IdPk implements Serializable {
        private static final long serialVersionUID = 1L;
    
        @ManyToOne
        @JoinColumn(name = "pedido_id")
        private Pedido pedido;
        
        @ManyToOne
        @JoinColumn(name = "produto_id")
        private Produto produto;
        
        public IdPk(){}

        public IdPk(Pedido pedido, Produto produto) {
            this.pedido = pedido;
            this.produto = produto;
        }

        public Pedido getPedido() {
            return pedido;
        }

        public void setPedido(Pedido pedido) {
            this.pedido = pedido;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        
        
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 73 * hash + Objects.hashCode(this.pedido);
            hash = 73 * hash + Objects.hashCode(this.produto);
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
            final IdPk other = (IdPk) obj;
            if (!Objects.equals(this.pedido, other.pedido)) {
                return false;
            }
            return Objects.equals(this.produto, other.produto);
        }
        
        
    }


    //atributos
    
    @EmbeddedId
    private IdPk id = new IdPk();
    
    private Double quantidade;
    private Double preco;
    
    //construtores
    
    public PedidoProduto(){}

    public PedidoProduto(Pedido pedido, Produto produto, Double quantidade, Double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
    }
    
    //metodos padroes

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getSubTotal(){
        return this.preco * this.quantidade;
    
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final PedidoProduto other = (PedidoProduto) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    // metodos da classe Embeddable Id.

    public void setPedido(Pedido pedido){
        this.id.setPedido(pedido);
    }
    
    @JsonIgnore
    public Pedido getPedido(){
        return this.id.getPedido();
    }

    public void setProduto(Produto produto){
        this.id.setProduto(produto);
}
 
    public Produto getProduto(){
        return this.id.getProduto();
    }
    
}

