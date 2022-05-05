package ufrn.br.aulawebrest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Return;
import ufrn.br.aulawebrest.model.Cliente;
import ufrn.br.aulawebrest.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return service
        .findById(id)   
        .map(cliente -> {
            return ResponseEntity.ok(cliente);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Cliente> listAll(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente c){
        return ResponseEntity.status(201).body(service.insert(c));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente c, @PathVariable Long id){
        return service
            .findById(id)
            .map(cliente -> {
                service.update(c);
                return ResponseEntity.ok().body(c);
        }).orElse(ResponseEntity.notFound().build());

    }

    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
            .findById(id)
            .map(cliente -> {
                service.delete(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }

   
}
