/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Services;

import br.ufsc.curso.AulaSpringBoot.Entities.Categoria;
import br.ufsc.curso.AulaSpringBoot.Entities.Pedido;
import br.ufsc.curso.AulaSpringBoot.Entities.Produto;
import br.ufsc.curso.AulaSpringBoot.Repositories.CategoriaRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.ProdutoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ventura
 */
@Service
public class ProdutoService {
    
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    public List <Produto> findAll(){
        return produtoRepository.findAll();
    }
    
    public Produto findById (Long id){
        try{
            
                return produtoRepository.findById(id).get();
        }catch (NoSuchElementException e) {
            throw new EntityNotFoundException(" EntityNotFoundException Produto id: " + id);
        }
    }
    
    
    public Produto save (Produto produto){
        return produtoRepository.save(produto);
    }
    
    
    public List <Produto> saveMany (List <Produto> produtos){
        
      //  List<Produto> savedProdutos = new ArrayList<>();       // Posso salvar uma lista de produtos utilizando um for OU
        //for(Produto p: produtos){
          //  savedProdutos.add(produtoRepository.save(p));
       // }return savedProdutos;
       
       return produtoRepository.saveAll(produtos);
        
    }
    
    
    
    public void delete (Long id){
        produtoRepository.deleteById(id);
    }
    
    public Produto update (Long id, Produto produto){
        Produto produtoEntity = produtoRepository.getReferenceById(id);
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setQuantidade(produto.getQuantidade());
        return produtoRepository.save(produtoEntity);

    }
        
     public Produto addCategoria (Long idProduto, Long idCategoria){
         Produto produto = produtoRepository.findById(idProduto).get();
         Categoria categoria = categoriaRepository.findById(idCategoria).get();
      
         produto.getCategorias().add(categoria);
         produtoRepository.save(produto);
         return produto;
        
    }

     public Produto removeCategoria (long idProduto, Long idCategoria){
         Produto produto = produtoRepository.findById(idProduto).get();
         Categoria categoria = categoriaRepository.findById(idCategoria).get();
         
         produto.getCategorias().remove(categoria);
         produtoRepository.save(produto);
         return produto;
     }
     
     
} 
    

