/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Services;

import br.ufsc.curso.AulaSpringBoot.Entities.Endereco;
import br.ufsc.curso.AulaSpringBoot.Repositories.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RC_Ve
 */
@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public List <Endereco> findAll(){
        return enderecoRepository.findAll();
    }
    
    public Endereco findById (Long id){
        return enderecoRepository.findById(id).get();
    }

    public Endereco save(Endereco end) {
        return enderecoRepository.save(end);
    }

    public void delete(long id) {
        enderecoRepository.deleteById(id);
    }

    public Endereco update(Long id, Endereco end) {
        Endereco enderecoEntity = enderecoRepository.getReferenceById(id);
        enderecoEntity.setTipo(end.getTipo());
        enderecoEntity.setRua(end.getRua());
        enderecoEntity.setNumero(end.getNumero());
        enderecoEntity.setCep(end.getCep());
        return enderecoRepository.save(end);
        
    }
    
}

    