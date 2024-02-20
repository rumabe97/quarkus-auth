package com.lemon.auth.content.user;

import com.lemon.auth.content.user.application.mapper.UserDomainMapper;
import org.mapstruct.MapperConfig;

import static org.mapstruct.MappingConstants.ComponentModel.CDI;
import static org.mapstruct.ReportingPolicy.IGNORE;


@MapperConfig(
        uses = {
                //TemplateDtoMapper.class,
                UserDomainMapper.class
        },
        unmappedTargetPolicy = IGNORE,
        componentModel = CDI,
        disableSubMappingMethodsGeneration = true)
public interface UserCentralizeMappingStrategy {
}
