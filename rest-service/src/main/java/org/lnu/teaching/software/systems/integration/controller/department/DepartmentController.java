package org.lnu.teaching.software.systems.integration.controller.department;

import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.service.department.DepartmentService;
import org.lnu.teaching.software.systems.integration.dto.department.BaseDepartmentDto;
import org.lnu.teaching.software.systems.integration.dto.department.DepartmentDto;
import org.lnu.teaching.software.systems.integration.dto.department.DepartmentItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto create(@RequestBody BaseDepartmentDto department) {
        return departmentService.create(department);
    }

    @GetMapping
    public List<DepartmentItemDto> findAll() {
        return departmentService.findAll();
    }
}
