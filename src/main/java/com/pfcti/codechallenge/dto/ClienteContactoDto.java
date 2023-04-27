package com.pfcti.codechallenge.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ClienteContactoDto {
    private int id;
    @NotNull
    @Length(max = 2, min = 2)
    private String paisResidencia;
    @NotNull
    private String direccionDomicilio;
    @NotNull
    private String telefono;
}
