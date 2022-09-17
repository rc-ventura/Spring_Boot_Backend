/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Services;

import br.ufsc.curso.AulaSpringBoot.Entities.Categoria;
import br.ufsc.curso.AulaSpringBoot.Entities.Categoria;
import br.ufsc.curso.AulaSpringBoot.Repositories.CategoriaRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.CategoriaRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.ProdutoRepository;
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
public class CategoriaService {
    
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    public List <Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    
    public Categoria findById (Long id){
        try{
            
                return categoriaRepository.findById(id).get();
        }catch (NoSuchElementException e) {
            throw new EntityNotFoundException(" EntityNotFoundException Categoria id: " + id);
        }
    }
    
    
    public Categoria save (Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    
    public void delete (Long id){
        categoriaRepository.deleteById(id);
    }
    
    public Categoria update (Long id, Categoria categoria){
        Categoria categoriaEntity = categoriaRepository.getReferenceById(id);
        categoriaEntity.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(categoriaEntity);

    }
     
}

