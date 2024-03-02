package com.lemon.auth.content.rol.application.mapper;

import com.lemon.auth.content.rol.RolCentralizeMappingStrategy;
import com.lemon.auth.content.rol.adapter.persistence.entity.RolEntity;
import com.lemon.auth.content.rol.domain.Rol;
import org.mapstruct.Mapper;

@Mapper(config = RolCentralizeMappingStrategy.class, disableSubMappingMethodsGeneration = true)
public interface RolDomainMapper {
    RolEntity toEntity(Rol rol);

    Rol toDomainModel(RolEntity rol);
}
