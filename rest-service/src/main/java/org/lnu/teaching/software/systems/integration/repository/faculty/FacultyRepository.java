package org.lnu.teaching.software.systems.integration.repository.faculty;

import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyPatch;
import org.lnu.teaching.software.systems.integration.dto.faculty.query.params.FacultyFitterOptions;
import org.lnu.teaching.software.systems.integration.entity.faculty.FacultyEntity;

import java.util.List;

public interface FacultyRepository {
    FacultyEntity create(FacultyEntity faculty);
    List<FacultyEntity> findAll(FacultyFitterOptions fitterOptions, Integer limit, Integer offset);
    FacultyEntity find(Long id);
    int count(FacultyFitterOptions params);
    void update(FacultyEntity faculty);
    void patch(Long id, FacultyPatch facultyPatch);
    void delete(Long id);
}
