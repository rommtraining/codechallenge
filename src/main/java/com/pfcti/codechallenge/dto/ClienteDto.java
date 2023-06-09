package com.pfcti.codechallenge.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ClienteDto {
    private int id;
    @NotNull
    private String identificacion;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @Length(max = 2, min = 2)
    private String paisResidencia;
    @Length(max = 2, min = 2)
    private String paisNacimiento;
    private String direccionDomicilio;
    private String telefono;
    private Boolean estado;
}
