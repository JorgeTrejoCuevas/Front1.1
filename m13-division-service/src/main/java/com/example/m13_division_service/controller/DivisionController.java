package com.example.m13_division_service.controller;

import com.example.m13_division_service.dto.DivisionDto;
import com.example.m13_division_service.service.DivisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/divisiones")
@Tag(name = "Divisiones", description = "API para la gestión de divisiones académicas")
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva división")
    public ResponseEntity<DivisionDto.Response> create(@Valid @RequestBody DivisionDto.Create dto) {
        DivisionDto.Response created = divisionService.create(dto);
        return ResponseEntity.created(URI.create("/api/divisiones/" + created.getId())).body(created);
    }

    @GetMapping
    @Operation(summary = "Obtener todas las divisiones")
    public ResponseEntity<List<DivisionDto.Response>> findAll() {
        return ResponseEntity.ok(divisionService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una división por su ID")
    public ResponseEntity<DivisionDto.Response> findOne(@PathVariable Integer id) {
        return ResponseEntity.ok(divisionService.findOne(id));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar una división existente")
    public ResponseEntity<DivisionDto.Response> update(
            @PathVariable Integer id,
            @Valid @RequestBody DivisionDto.Update dto) {
        return ResponseEntity.ok(divisionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una división")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        divisionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}