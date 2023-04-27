package com.pfcti.codechallenge.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteDto {
    private int id;
    @NotNull
    private String identificacion;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private String paisResidencia;
    private String paisNacimiento;
    private String direccionDomicilio;
    private String telefono;
    private Boolean estado;
}
