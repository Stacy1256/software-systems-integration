package org.lnu.teaching.software.systems.integration.service.department;

import org.lnu.teaching.software.systems.integration.dto.department.BaseDepartmentDto;
import org.lnu.teaching.software.systems.integration.dto.department.DepartmentDto;
import org.lnu.teaching.software.systems.integration.dto.department.DepartmentItemDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(BaseDepartmentDto department);
    List<DepartmentItemDto> findAll();
}
