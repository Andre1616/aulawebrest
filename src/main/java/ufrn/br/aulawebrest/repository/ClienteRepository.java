package ufrn.br.aulawebrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufrn.br.aulawebrest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}