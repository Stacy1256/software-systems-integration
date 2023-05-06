package org.lnu.teaching.software.systems.integration.service.department.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.dto.department.BaseDepartmentDto;
import org.lnu.teaching.software.systems.integration.dto.department.DepartmentDto;
import org.lnu.teaching.software.systems.integration.dto.department.DepartmentItemDto;
import org.lnu.teaching.software.systems.integration.entity.department.DepartmentEntity;
import org.lnu.teaching.software.systems.integration.mapper.DepartmentMapper;
import org.lnu.teaching.software.systems.integration.repository.department.DepartmentRepository;
import org.lnu.teaching.software.systems.integration.service.department.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto create(BaseDepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = departmentMapper.toEntity(departmentDto);
        DepartmentEntity createdDepartmentEntity = departmentRepository.create(departmentEntity);
        return departmentMapper.toDto(createdDepartmentEntity);
    }

    @Override
    public List<DepartmentItemDto> findAll() {
        return departmentMapper.toDepartmentItems(departmentRepository.findAll());
    }
}
