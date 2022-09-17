/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Repositories;

import br.ufsc.curso.AulaSpringBoot.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RC_Ve
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
