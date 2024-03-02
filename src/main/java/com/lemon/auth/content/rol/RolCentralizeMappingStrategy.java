package com.lemon.auth.content.rol;

import com.lemon.auth.content.rol.adapter.rest.mapper.RolDtoMapper;
import com.lemon.auth.content.rol.application.mapper.RolDomainMapper;
import org.mapstruct.MapperConfig;

import static org.mapstruct.MappingConstants.ComponentModel.CDI;
import static org.mapstruct.ReportingPolicy.IGNORE;

@MapperConfig(
        uses = {
                RolDomainMapper.class,
                RolDtoMapper.class
        },
        unmappedTargetPolicy = IGNORE,
        componentModel = CDI,
        disableSubMappingMethodsGeneration = true)
public interface RolCentralizeMappingStrategy {
}
