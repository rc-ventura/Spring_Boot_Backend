/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author RC_Ventura
 */

@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    //atributos 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String descricao;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private Set <Produto> produtos = new HashSet<>(); 
    
    //contrutores 
    
    public Categoria(){}

    public Categoria(Long id, String descricao ) {
        this.id = id;
        this.descricao = descricao;
       
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.id, other.id);
    }

    
     
    
}
