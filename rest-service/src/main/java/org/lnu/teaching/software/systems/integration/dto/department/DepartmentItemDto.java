package org.lnu.teaching.software.systems.integration.dto.department;

import lombok.Data;

@Data
public class DepartmentItemDto {
    private Long id;
    private String name;
    private Long facultyId;
    private String facultyName;
}
