package org.lnu.teaching.software.systems.integration.controller.mutation;

import org.lnu.teaching.software.systems.integration.entity.mutation.departments.DepartmentMutations;
import org.lnu.teaching.software.systems.integration.entity.mutation.faculties.FacultyMutations;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationController {
    @MutationMapping
    public FacultyMutations faculties()  {
        return new FacultyMutations();
    }
    @MutationMapping
    public DepartmentMutations departments()  {
        return new DepartmentMutations();
    }
}
