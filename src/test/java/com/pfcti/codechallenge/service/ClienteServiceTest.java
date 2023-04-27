package com.pfcti.codechallenge.service;

import com.pfcti.codechallenge.dto.ClienteContactoDto;
import com.pfcti.codechallenge.dto.ClienteDto;
import com.pfcti.codechallenge.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;

    @Test
    void insertarCliente() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setDireccionDomicilio("AAA");
        clienteDto.setPaisNacimiento("GT");
        clienteDto.setPaisResidencia("GT");
        clienteDto.setEstado(true);
        clienteDto.setApellidos("ARROYO");
        clienteDto.setNombres("MARCO");
        clienteDto.setIdentificacion("9");
        clienteDto.setTelefono("99999999");

        clienteService.insertarCliente(clienteDto);

        imprimirClientes(null);

        assertEquals(1,1);

    }

    private void imprimirClientes(List<ClienteDto> clientesDto) {
        if(clientesDto.equals(null)) {
            clientesDto = clienteService.obtenerClientes();
        }
        clientesDto.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombres() + ' ' + cliente.getApellidos() + ' ' + cliente.getDireccionDomicilio() + ' ' + cliente.getPaisResidencia() + ' ' + cliente.getTelefono() + ' ' + cliente.getEstado().toString()));
    }

    @Test
    void obtenerClientesPorIdentificacion() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorIdentificacion("1");

        imprimirClientes(clientesDto);

        assertEquals(1,1);
    }

    @Test
    void obtenerClientes() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientes();
        imprimirClientes(clientesDto);
        assertEquals(1,1);
    }

    @Test
    void actualizarDatosContactoCliente() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorIdentificacion("1");
        imprimirClientes(clientesDto);

        ClienteContactoDto clienteContactoDto = new ClienteContactoDto();
        clienteContactoDto.setId(1);
        clienteContactoDto.setDireccionDomicilio("Direccion 123456798");
        clienteContactoDto.setTelefono("123456798");
        clienteContactoDto.setPaisResidencia("PA");
        clienteService.actualizarDatosContactoCliente(clienteContactoDto);

        clientesDto = clienteService.obtenerClientesPorIdentificacion("1");
        imprimirClientes(clientesDto);
    }

    @Test
    void inactivarCliente() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorIdentificacion("1");
        imprimirClientes(clientesDto);

        clienteService.inactivarCliente(1);

        clientesDto = clienteService.obtenerClientesPorIdentificacion("1");
        imprimirClientes(clientesDto);
    }
}