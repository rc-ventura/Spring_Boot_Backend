package br.ufsc.curso.AulaSpringBoot.services;

import br.ufsc.curso.AulaSpringBoot.Entities.Cliente;
import br.ufsc.curso.AulaSpringBoot.Entities.Endereco;
import br.ufsc.curso.AulaSpringBoot.Repositories.ClienteRepository;
import br.ufsc.curso.AulaSpringBoot.Repositories.EnderecoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente addEndereco(Long idCliente, Long idEndereco) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        Endereco endereco = enderecoRepository.findById(idEndereco).get();

        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);

        return cliente;
    }

    public Cliente removeEndereco(Long idCliente, Long idEndereco) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        Endereco endereco = enderecoRepository.findById(idEndereco).get();

        endereco.setCliente(null);
        enderecoRepository.save(endereco);

        return cliente;
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteEntity = clienteRepository.getReferenceById(id);

        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setFone(cliente.getFone());
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setSenha(cliente.getSenha());

        return clienteRepository.save(clienteEntity);
    }

    public void deleteById(Long id) {
        //try {
        clienteRepository.deleteById(id);
        //}catch (RuntimeException e) {
        //	e.printStackTrace();
        //}

    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        try {
            return clienteRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("EntityNotFoundException Cliente id: " + id);
        }
    }

}
