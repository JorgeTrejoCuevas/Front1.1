package com.example.schedule.m9_schedule_service.repository;

import com.example.schedule.m9_schedule_service.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
    List<ScheduleEntity> findByIdProfesor(Integer idProfesor);
    List<ScheduleEntity> findByIdProfesorAndDisponible(Integer idProfesor, Boolean disponible);
}

