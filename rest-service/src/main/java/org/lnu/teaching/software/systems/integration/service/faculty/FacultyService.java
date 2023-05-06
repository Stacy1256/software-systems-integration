package org.lnu.teaching.software.systems.integration.service.faculty;

import org.lnu.teaching.software.systems.integration.dto.common.ValueDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyPatch;
import org.lnu.teaching.software.systems.integration.dto.faculty.query.params.FacultyFitterOptions;

import java.util.List;

public interface FacultyService {
    FacultyDto create(BaseFacultyDto faculty);
    List<FacultyDto> findAll(FacultyFitterOptions fitterOptions, Integer limit, Integer offset);
    FacultyDto find(Long id);
    ValueDto<Integer> count(FacultyFitterOptions params);
    void update(Long id, BaseFacultyDto facultyDto);
    void patch(Long id, FacultyPatch facultyPatch);
    void delete(Long id);
}
