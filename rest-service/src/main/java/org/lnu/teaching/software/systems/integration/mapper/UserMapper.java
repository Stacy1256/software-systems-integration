package org.lnu.teaching.software.systems.integration.mapper;


import org.lnu.teaching.software.systems.integration.dto.user.UserCreateDto;
import org.lnu.teaching.software.systems.integration.dto.user.UserDto;
import org.lnu.teaching.software.systems.integration.entity.user.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserCreateDto userDto);
    UserDto toDto(UserEntity userEntity);
    List<UserDto> toDtoList(List<UserEntity> userEntities);
}
