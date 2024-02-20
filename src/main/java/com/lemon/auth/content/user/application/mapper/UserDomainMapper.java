package com.lemon.auth.content.user.application.mapper;

import com.lemon.auth.content.user.UserCentralizeMappingStrategy;
import com.lemon.auth.content.user.adapter.persistence.entity.UserEntity;
import com.lemon.auth.content.user.adapter.rest.dto.in.SearchUserInDto;
import com.lemon.auth.content.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(config = UserCentralizeMappingStrategy.class, disableSubMappingMethodsGeneration = true)
public interface UserDomainMapper {

    UserEntity toEntity(User user);

    User toDomainModel(UserEntity user);
    User searchToDomainModel(SearchUserInDto user);
}
