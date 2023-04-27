package com.pfcti.codechallenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String identificacion;
    @Column
    private String nombres;
    @Column
    private String apellidos;
    @Column
    private String paisResidencia;
    @Column
    private String paisNacimiento;
    @Column
    private String direccionDomicilio;
    @Column
    private String telefono;
    @Column
    private Boolean estado;
}
