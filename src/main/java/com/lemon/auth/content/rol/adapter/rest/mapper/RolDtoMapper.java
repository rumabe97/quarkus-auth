package com.lemon.auth.content.rol.adapter.rest.mapper;

import com.lemon.auth.content.rol.RolCentralizeMappingStrategy;
import com.lemon.auth.content.rol.adapter.rest.dto.out.RolOutDto;
import com.lemon.auth.content.rol.domain.Rol;
import org.mapstruct.Mapper;

@Mapper(config = RolCentralizeMappingStrategy.class, disableSubMappingMethodsGeneration = true)
public interface RolDtoMapper {
    RolOutDto toOutDto(Rol rol);
}
