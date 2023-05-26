package org.lnu.teaching.software.systems.integration.controller.query;

import org.lnu.teaching.software.systems.integration.entity.query.departments.DepartmentQueries;
import org.lnu.teaching.software.systems.integration.entity.query.faculties.FacultyQueries;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {
    @QueryMapping
    public FacultyQueries faculties() {
        return new FacultyQueries();
    }
    @QueryMapping
    public DepartmentQueries departments() {
        return new DepartmentQueries();
    }
}
