package com.example.schedule.m9_schedule_service.controller;

import com.example.schedule.m9_schedule_service.dto.ScheduleDto;
import com.example.schedule.m9_schedule_service.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping
    public ResponseEntity<List<ScheduleDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/profesor/{idProfesor}")
    public ResponseEntity<List<ScheduleDto>> getByProfesor(@PathVariable Integer idProfesor) {
        return ResponseEntity.ok(service.findByProfesor(idProfesor));
    }

    @GetMapping("/profesor/{idProfesor}/disponibles")
    public ResponseEntity<List<ScheduleDto>> getDisponibles(@PathVariable Integer idProfesor) {
        return ResponseEntity.ok(service.findDisponiblesByProfesor(idProfesor));
    }

    @PostMapping
    public ResponseEntity<ScheduleDto> create(@RequestBody ScheduleDto dto) {
        ScheduleDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/schedule/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDto> update(@PathVariable Integer id, @RequestBody ScheduleDto dto) {
        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.delete(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}