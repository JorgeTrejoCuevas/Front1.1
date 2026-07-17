package com.example.schedule.m9_schedule_service.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class ScheduleDto {
    private Integer id;
    private Short dia;
    private LocalTime hora;
    private Boolean disponible;
    private Integer idProfesor;
}
