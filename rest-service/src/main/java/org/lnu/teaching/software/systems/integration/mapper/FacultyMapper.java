package org.lnu.teaching.software.systems.integration.mapper;

import org.lnu.teaching.software.systems.integration.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyDto;
import org.lnu.teaching.software.systems.integration.entity.faculty.FacultyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    FacultyEntity toEntity(BaseFacultyDto facultyDto);
    FacultyDto toDto(FacultyEntity facultyEntity);
    List<FacultyDto> toDtoList(List<FacultyEntity> facultyEntities);
}
