package ufrn.br.aulawebrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import ufrn.br.aulawebrest.model.Cliente;
import ufrn.br.aulawebrest.repository.ClienteRepository;

@Service
public class ClienteService {

    
    ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public ResponseEntity<Cliente> insert(Cliente c){
        return repository.save(c);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Cliente> listAll(){
        return repository.findAll();
    }

    public Optional<Cliente>findById(Long id){
        return repository.findById(id);
    }

    public Cliente update(Cliente c){
        return repository.saveAndFlush(c);
    }

    
}