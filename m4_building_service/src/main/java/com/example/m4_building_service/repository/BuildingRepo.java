package com.example.m4_building_service.repository;

import com.example.m4_building_service.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepo extends JpaRepository<BuildingEntity, Long> { 
    // Asegúrate de que diga: JpaRepository<BuildingEntity, Long>
}