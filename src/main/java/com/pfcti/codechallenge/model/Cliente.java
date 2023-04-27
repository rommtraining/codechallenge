package com.pfcti.codechallenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String paisResidencia;
    private String paisNacimiento;
    private String direccionDomicilio;
    private String telefono;
    private Boolean estado;
}
