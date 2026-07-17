package com.example.m4_building_service.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BuildingDto {

    // ==========================================
    // 1. DTO PARA CREACIÓN
    // ==========================================
    @Data
    @Schema(description = "Modelo para la creación de un edificio")
    public static class Create {

        @NotNull(message = "El ID de la división es obligatorio.")
        @Schema(description = "ID de la división a la que está asignado el edificio", example = "1")
        private Long idDivision;

        @NotBlank(message = "El nombre del edificio es obligatorio.")
        @Size(max = 150, message = "El nombre no puede superar los 150 caracteres.")
        @Schema(description = "Nombre completo del edificio.", example = "Edificio G")
        private String nombre;

        @Size(max = 20, message = "La abreviatura no puede superar los 20 caracteres.")
        @Schema(description = "Abreviatura del edificio.", example = "ED-G", nullable = true)
        private String abreviatura;

        @NotBlank(message = "El tipo de edificio es obligatorio.")
        @Schema(description = "Tipo de edificio.", example = "Académico")
        private String tipo;
    }

    // ==========================================
    // 2. DTO PARA ACTUALIZACIÓN
    // ==========================================
    @Data
    @Schema(description = "Modelo para la actualización parcial de un edificio")
    public static class Update {

        @Schema(description = "ID de la división a la que está asignado el edificio", example = "1", nullable = true)
        private Long idDivision;

        @Size(max = 150, message = "El nombre no puede superar los 150 caracteres.")
        @Schema(description = "Nombre completo del edificio.", example = "Edificio G Modificado", nullable = true)
        private String nombre;

        @Size(max = 20, message = "La abreviatura no puede superar los 20 caracteres.")
        @Schema(description = "Abreviatura del edificio.", example = "ED-GM", nullable = true)
        private String abreviatura;

        @Schema(description = "Tipo de edificio.", example = "Laboratorio", nullable = true)
        private String tipo;
    }
}