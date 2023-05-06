package org.lnu.teaching.software.systems.integration.controller.faculty;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.annotation.Auth;
import org.lnu.teaching.software.systems.integration.dto.common.ValueDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyDto;
import org.lnu.teaching.software.systems.integration.dto.faculty.FacultyPatch;
import org.lnu.teaching.software.systems.integration.service.faculty.FacultyService;
import org.lnu.teaching.software.systems.integration.dto.faculty.query.params.FacultyFitterOptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Auth
@RestController
@AllArgsConstructor
@RequestMapping("faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @Auth(isAdmin = true)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FacultyDto create(@RequestBody BaseFacultyDto faculty) {
        return facultyService.create(faculty);
    }

    @GetMapping
    @Operation(
            parameters = {
                    @Parameter(name = "name"),
                    @Parameter(name = "info")
            }
    )
    public List<FacultyDto> findAll(@Parameter(hidden = true) FacultyFitterOptions fitterOptions,
                                    @RequestParam(required = false) Integer limit,
                                    @RequestParam(required = false) Integer offset) {
        return facultyService.findAll(fitterOptions, limit, offset);
    }

    @GetMapping("{id}")
    public FacultyDto find(@PathVariable Long id) {
        return facultyService.find(id);
    }

    @GetMapping("count")
    @Operation(
            parameters = {
                    @Parameter(name = "name"),
                    @Parameter(name = "info")
            }
    )
    public ValueDto<Integer> count(@Parameter(hidden = true) FacultyFitterOptions params) {
        return facultyService.count(params);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody BaseFacultyDto faculty) {
        facultyService.update(id, faculty);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patch(@PathVariable Long id, @RequestBody FacultyPatch facultyPatch) {
        facultyService.patch(id, facultyPatch);
    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facultyService.delete(id);
    }
}
