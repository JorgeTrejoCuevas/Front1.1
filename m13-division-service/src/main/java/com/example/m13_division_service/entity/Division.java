package com.example.m13_division_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "abreviatura", length = 20, nullable = false)
    private String abreviatura;

    // Constructor vacío
    public Division() {}

    // Constructor con parámetros
    public Division(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAbreviatura() { return abreviatura; }
    public void setAbreviatura(String abreviatura) { this.abreviatura = abreviatura; }
}