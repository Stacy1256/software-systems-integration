package org.lnu.teaching.software.systems.integration.entity.department;

import lombok.Data;
import org.lnu.teaching.software.systems.integration.entity.faculty.FacultyEntity;

@Data
public class DepartmentEntity {
    private Long id;
    private FacultyEntity faculty;
    private String name;
    private String email;
    private String phone;
    private String info;
}

