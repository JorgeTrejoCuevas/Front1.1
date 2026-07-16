package com.example.m4_building_service.service;

import com.example.m4_building_service.dto.BuildingDto;
import com.example.m4_building_service.entity.BuildingEntity;
import java.util.List;

public interface BuildingService {
    
    // CREATE (Usando el DTO unificado)
    BuildingEntity create(BuildingDto.Create createBuildingDto);
    
    // READ ALL
    List<BuildingEntity> findAll();
    
    // READ ONE
    BuildingEntity findOne(Long id);
    
    // UPDATE (Usando el DTO unificado)
    BuildingEntity update(Long id, BuildingDto.Update updateBuildingDto);
    
    // DELETE
    void remove(Long id);
}