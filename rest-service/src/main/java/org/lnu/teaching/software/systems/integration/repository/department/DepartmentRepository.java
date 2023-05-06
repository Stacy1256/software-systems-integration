package org.lnu.teaching.software.systems.integration.repository.department;

import org.lnu.teaching.software.systems.integration.entity.department.DepartmentEntity;

import java.util.List;

public interface DepartmentRepository {
    DepartmentEntity create(DepartmentEntity department);
    List<DepartmentEntity> findAll();
}
