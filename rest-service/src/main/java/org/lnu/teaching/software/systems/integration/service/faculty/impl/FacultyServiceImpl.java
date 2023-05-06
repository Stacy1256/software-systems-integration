package org.lnu.teaching.software.systems.integration.service.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.exception.BadRequestException;
import org.lnu.teaching.software.systems.integration.dto.common.ValueDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyPatch;
import org.lnu.teaching.software.systems.integration.dto.faculty.query.params.FacultyFitterOptions;
import org.lnu.teaching.software.systems.integration.entity.faculty.FacultyEntity;
import org.lnu.teaching.software.systems.integration.mapper.FacultyMapper;
import org.lnu.teaching.software.systems.integration.repository.faculty.FacultyRepository;
import org.lnu.teaching.software.systems.integration.service.faculty.FacultyService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private static final String FACULTIES_CACHE_PREFIX = "FACULTIES";
    private static final String FACULTIES_COUNT_CACHE_PREFIX = "FACULTIES_COUNT";
    private static final String FACULTY_CACHE_PREFIX = "FACULTY";

    private final FacultyRepository facultyRepository;

    private final FacultyMapper facultyMapper;

    @Override
    @CacheEvict({FACULTIES_CACHE_PREFIX, FACULTY_CACHE_PREFIX, FACULTIES_COUNT_CACHE_PREFIX})
    public FacultyDto create(BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        FacultyEntity createdFacultyEntity = facultyRepository.create(facultyEntity);
        return facultyMapper.toDto(createdFacultyEntity);
    }

    @Override
    @Cacheable(FACULTIES_CACHE_PREFIX)
    public List<FacultyDto> findAll(@RequestParam(required = false) FacultyFitterOptions fitterOptions, @RequestParam(defaultValue = "100", required = false) Integer limit, @RequestParam(defaultValue = "0", required = false) Integer offset) {
        List<FacultyEntity> facultyEntities = facultyRepository.findAll(fitterOptions, limit, offset);
        return facultyMapper.toDtoList(facultyEntities);
    }

    @Override
    @Cacheable(FACULTY_CACHE_PREFIX)
    public FacultyDto find(Long id) {
        FacultyEntity facultyEntity = facultyRepository.find(id);
        return facultyMapper.toDto(facultyEntity);
    }

    @Override
    @Cacheable(FACULTIES_COUNT_CACHE_PREFIX)
    public ValueDto<Integer> count(FacultyFitterOptions params) {
        int count = facultyRepository.count(params);
        return new ValueDto<>(count);
    }

    @Override
    @CacheEvict({FACULTIES_CACHE_PREFIX, FACULTY_CACHE_PREFIX})
    public void update(Long id, BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        facultyEntity.setId(id);

        facultyRepository.update(facultyEntity);
    }

    @Override
    @CacheEvict({FACULTIES_CACHE_PREFIX, FACULTY_CACHE_PREFIX})
    public void patch(Long id, FacultyPatch facultyPatch) {
        if (facultyPatch.isEmpty()) {
            throw new BadRequestException("Faculty patch is empty!");
        }

        facultyRepository.patch(id, facultyPatch);
    }

    @Override
    @CacheEvict({FACULTIES_CACHE_PREFIX, FACULTY_CACHE_PREFIX, FACULTIES_COUNT_CACHE_PREFIX})
    public void delete(Long id) {
        facultyRepository.delete(id);
    }
}
