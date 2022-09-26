/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufsc.curso.AulaSpringBoot.Repositories;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author RC_Ve
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
//criando um metodo personalizado de QUERY SQL
    
    @Query(value = "SELECT * FROM cliente WHERE cliente.id NOT IN("
            + "SELECT pedido.cliente_id FROM PEDIDo)", nativeQuery = true)
    public List <Cliente> findNoBuy();  // clientes que nao estao associados a nenhum ´pedido
   //nao fizeram nenhum compra

//criando um metodo personalizado SQL para busca pelo nome
    
    @Query( value = "SELECT * FROM cliente WHERE cliente.nome LIKE %?1%", nativeQuery = true)
    public List <Cliente> findByNameFilter (String filter);


}