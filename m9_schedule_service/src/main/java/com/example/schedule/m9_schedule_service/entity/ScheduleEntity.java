package com.example.schedule.m9_schedule_service.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "horario_profesor")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int2")
    private Short dia;

    @Column(columnDefinition = "TIME")
    private LocalTime hora;

    @Column
    private Boolean disponible = true;

    @Column(name = "id_profesor")
    private Integer idProfesor;
}