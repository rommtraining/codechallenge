package com.pfcti.codechallenge.repository;

import com.pfcti.codechallenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
    List<Cliente> findClientesByIdentificacion(String identificacion);

}
