package com.pfcti.codechallenge.repository;

import com.pfcti.codechallenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
    List<Cliente> findClientesByIdentificacion(String identificacion);

    @Modifying
    @Query("update Cliente c set c.paisResidencia = :paisResidencia, c.direccionDomicilio = :direccionDomicilio, c.telefono = :telefono where c.id = :id")
    void actualizarDatosContactoCliente(String paisResidencia, String direccionDomicilio, String telefono, int id);

    @Modifying
    @Query("update Cliente c set c.estado = false where c.id = :id")
    void inactivarCliente(int id);
}
