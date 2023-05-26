package org.lnu.teaching.software.systems.integration.service.department;

import graphql.GraphQLContext;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.lnu.teaching.software.systems.integration.service.common.CommonEntityService;
import org.lnu.teaching.software.systems.integration.entity.common.response.CreateMutationResponse;
import org.lnu.teaching.software.systems.integration.entity.common.response.MutationResponse;
import org.lnu.teaching.software.systems.integration.entity.department.Department;
import org.lnu.teaching.software.systems.integration.entity.department.error.status.DepartmentCreateErrorStatus;
import org.lnu.teaching.software.systems.integration.entity.department.error.status.DepartmentDeleteErrorStatus;
import org.lnu.teaching.software.systems.integration.entity.department.error.status.DepartmentUpdateErrorStatus;
import org.lnu.teaching.software.systems.integration.entity.faculty.Faculty;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface DepartmentService extends CommonEntityService<Department> {
    Mono<CreateMutationResponse<Department, DepartmentCreateErrorStatus>> create(Department Department, DataFetchingFieldSelectionSet fs);
    Mono<MutationResponse<DepartmentUpdateErrorStatus>> update(Long id, Department department);
    Mono<MutationResponse<DepartmentDeleteErrorStatus>> delete(Long id);
    Mono<Map<Faculty, List<Department>>> findForFaculties(List<Faculty> faculties, GraphQLContext context);
}
