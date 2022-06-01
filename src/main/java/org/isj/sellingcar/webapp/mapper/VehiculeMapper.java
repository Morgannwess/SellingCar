package org.isj.sellingcar.webapp.mapper;


import org.isj.sellingcar.webapp.model.dto.VehiculeDTO;
import org.isj.sellingcar.webapp.model.entities.Vehicule;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface VehiculeMapper {

    Vehicule toEntity(VehiculeDTO vehiculeDTO);

    VehiculeDTO toDto(Vehicule vehicule);

    void copy(VehiculeDTO vehiculeDTO, @MappingTarget Vehicule vehicule);

}

