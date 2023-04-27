package com.pfcti.codechallenge.api;

import com.pfcti.codechallenge.dto.ClienteDto;
import com.pfcti.codechallenge.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteApi {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/por-identificacion/{identificacion}")
    public List<ClienteDto> obtenerClientesPorIdentificacion(@PathVariable String identificacion) {
        return clienteService.obtenerClientesPorIdentificacion(identificacion);
    }

    @GetMapping("/todos")
    public List<ClienteDto> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insertarCliente(@Valid @RequestBody ClienteDto clienteDto){
        clienteService.insertarCliente(clienteDto);
    }
}
