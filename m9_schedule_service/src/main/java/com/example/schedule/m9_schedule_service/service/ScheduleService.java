package com.example.schedule.m9_schedule_service.service;

import com.example.schedule.m9_schedule_service.dto.ScheduleDto;
import com.example.schedule.m9_schedule_service.entity.ScheduleEntity;
import com.example.schedule.m9_schedule_service.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Transactional(readOnly = true)
    public List<ScheduleDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ScheduleDto> findById(Integer id) {
        return repository.findById(id).map(this::toDto);
    }

    @Transactional(readOnly = true)
    public List<ScheduleDto> findByProfesor(Integer idProfesor) {
        return repository.findByIdProfesor(idProfesor).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ScheduleDto> findDisponiblesByProfesor(Integer idProfesor) {
        return repository.findByIdProfesorAndDisponible(idProfesor, true)
                .stream().map(this::toDto).collect(Collectors.toList());
    }

    @Transactional
    public ScheduleDto create(ScheduleDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    @Transactional
    public Optional<ScheduleDto> update(Integer id, ScheduleDto dto) {
        return repository.findById(id).map(existing -> {
            existing.setDia(dto.getDia());
            existing.setHora(dto.getHora());
            existing.setDisponible(dto.getDisponible());
            existing.setIdProfesor(dto.getIdProfesor());
            return toDto(repository.save(existing));
        });
    }

    @Transactional
    public boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private ScheduleDto toDto(ScheduleEntity e) {
        ScheduleDto d = new ScheduleDto();
        d.setId(e.getId());
        d.setDia(e.getDia());
        d.setHora(e.getHora());
        d.setDisponible(e.getDisponible());
        d.setIdProfesor(e.getIdProfesor());
        return d;
    }

    private ScheduleEntity toEntity(ScheduleDto d) {
        ScheduleEntity e = new ScheduleEntity();
        e.setDia(d.getDia());
        e.setHora(d.getHora());
        e.setDisponible(d.getDisponible());
        e.setIdProfesor(d.getIdProfesor());
        return e;
    }
}