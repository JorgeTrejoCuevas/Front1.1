package com.example.m13_division_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTOs para el manejo de Divisiones
 * Contiene: Create, Update y Response
 */
public class DivisionDto {

    // ============================================================
    // CREATE DTO
    // ============================================================
    public static class Create {
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 150, message = "El nombre no puede tener más de 150 caracteres")
        private String nombre;

        @NotBlank(message = "La abreviatura es obligatoria")
        @Size(max = 20, message = "La abreviatura no puede tener más de 20 caracteres")
        private String abreviatura;

        // Getters y Setters
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getAbreviatura() { return abreviatura; }
        public void setAbreviatura(String abreviatura) { this.abreviatura = abreviatura; }
    }

    // ============================================================
    // UPDATE DTO
    // ============================================================
    public static class Update {
        @Size(max = 150, message = "El nombre no puede tener más de 150 caracteres")
        private String nombre;

        @Size(max = 20, message = "La abreviatura no puede tener más de 20 caracteres")
        private String abreviatura;

        // Getters y Setters
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getAbreviatura() { return abreviatura; }
        public void setAbreviatura(String abreviatura) { this.abreviatura = abreviatura; }
    }

    // ============================================================
    // RESPONSE DTO
    // ============================================================
    public static class Response {
        private Integer id;
        private String nombre;
        private String abreviatura;

        // Constructor vacío
        public Response() {}

        // Constructor con parámetros
        public Response(Integer id, String nombre, String abreviatura) {
            this.id = id;
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

        // Método estático para convertir desde Entity
        public static Response fromEntity(com.example.m13_division_service.entity.Division division) {
            return new Response(
                division.getId(),
                division.getNombre(),
                division.getAbreviatura()
            );
        }
    }
}