package com.example.m4_building_service.service;

import com.example.m4_building_service.dto.BuildingDto;
import com.example.m4_building_service.entity.BuildingEntity;
import com.example.m4_building_service.repository.BuildingRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepo buildingRepo;

    // Inyección de dependencias por constructor limpia y única
    public BuildingServiceImpl(BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }

    // CREATE (Adaptado al DTO unificado BuildingDto.Create y a la nueva estructura)
    @Override
    @Transactional
    public BuildingEntity create(BuildingDto.Create createBuildingDto) {
        BuildingEntity building = new BuildingEntity();
        building.setNombre(createBuildingDto.getNombre());
        building.setAbreviatura(createBuildingDto.getAbreviatura());
        building.setTipo(createBuildingDto.getTipo());
        building.setIdDivision(createBuildingDto.getIdDivision()); // Mapeamos el ID numérico directo
        
        return buildingRepo.save(building);
    }

    // READ ALL
    @Override
    @Transactional(readOnly = true)
    public List<BuildingEntity> findAll() {
        return buildingRepo.findAll();
    }

    // READ ONE (Soluciona el error de tipos usando el parámetro Long id)
    @Override
    @Transactional(readOnly = true)
    public BuildingEntity findOne(Long id) {
        return buildingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Edificio con ID \"" + id + "\" no encontrado."));
    }

    // UPDATE (Adaptado al DTO unificado BuildingDto.Update y de forma selectiva)
    @Override
    @Transactional
    public BuildingEntity update(Long id, BuildingDto.Update updateBuildingDto) {
        BuildingEntity building = findOne(id); // Si no existe, lanza la excepción de findOne automáticamente

        // Mapeo seguro contra valores nulos (Equivalente al merge de TypeORM)
        if (updateBuildingDto.getNombre() != null) {
            building.setNombre(updateBuildingDto.getNombre());
        }
        if (updateBuildingDto.getAbreviatura() != null) {
            building.setAbreviatura(updateBuildingDto.getAbreviatura());
        }
        if (updateBuildingDto.getTipo() != null) {
            building.setTipo(updateBuildingDto.getTipo());
        }
        if (updateBuildingDto.getIdDivision() != null) {
            building.setIdDivision(updateBuildingDto.getIdDivision());
        }

        return buildingRepo.save(building);
    }

    // DELETE (Soluciona el error usando existsById y deleteById de forma segura con Long)
    @Override
    @Transactional
    public void remove(Long id) {
        if (!buildingRepo.existsById(id)) {
            throw new RuntimeException("Edificio con ID \"" + id + "\" no encontrado.");
        }
        buildingRepo.deleteById(id);
    }
}