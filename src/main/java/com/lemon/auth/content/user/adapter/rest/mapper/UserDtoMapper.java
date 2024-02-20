package com.lemon.auth.content.user.adapter.rest.mapper;

import com.lemon.auth.content.user.UserCentralizeMappingStrategy;
import com.lemon.auth.content.user.adapter.rest.dto.in.SearchUserInDto;
import com.lemon.auth.content.user.adapter.rest.dto.in.UpdateUserInDto;
import com.lemon.auth.content.user.adapter.rest.dto.in.UserInDto;
import com.lemon.auth.content.user.adapter.rest.dto.out.UserOutDto;
import com.lemon.auth.content.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = UserCentralizeMappingStrategy.class, disableSubMappingMethodsGeneration = true)
public interface UserDtoMapper {

    User toDomainModel(UserInDto user);
    User toDomainModel(SearchUserInDto user);
    User toDomainModel(UpdateUserInDto user);

    UserOutDto toOutDto(User user);

}
