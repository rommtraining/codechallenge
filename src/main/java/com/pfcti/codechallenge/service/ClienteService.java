package com.pfcti.codechallenge.service;

import com.pfcti.codechallenge.dto.ClienteContactoDto;
import com.pfcti.codechallenge.dto.ClienteDto;
import com.pfcti.codechallenge.model.Cliente;
import com.pfcti.codechallenge.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public void insertarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(clienteDto.getIdentificacion());
        cliente.setNombres(clienteDto.getNombres());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setPaisResidencia(clienteDto.getPaisResidencia());
        cliente.setPaisNacimiento(clienteDto.getPaisNacimiento());
        cliente.setDireccionDomicilio(clienteDto.getDireccionDomicilio());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setEstado(clienteDto.getEstado());
        clienteRepository.save(cliente);
    }

    public List<ClienteDto> obtenerClientesPorIdentificacion(String identificacion) {
        List<Cliente> clientes = clienteRepository.findClientesByIdentificacion(identificacion);
        List<ClienteDto> clientesDto = new ArrayList();
        clientes.forEach(cliente -> {
            clientesDto.add(deClienteAClienteDto(cliente));
        });

        return clientesDto;
    }

    public List<ClienteDto> obtenerClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDto> clientesDto = new ArrayList();
        clientes.forEach(cliente -> {
            clientesDto.add(deClienteAClienteDto(cliente));
        });

        return clientesDto;
    }

    public void actualizarDatosContactoCliente(ClienteContactoDto clienteContactoDto){
        clienteRepository.actualizarDatosContactoCliente(clienteContactoDto.getPaisResidencia(),
                clienteContactoDto.getDireccionDomicilio(), clienteContactoDto.getTelefono(),
                clienteContactoDto.getId());
    }

    public void inactivarCliente(int id){
        clienteRepository.inactivarCliente(id);
    }

    private ClienteDto deClienteAClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();

        BeanUtils.copyProperties(cliente, clienteDto);

        return clienteDto;
    }

    private Cliente deClienteDtoACliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(clienteDto, cliente);

        return cliente;
    }


}
