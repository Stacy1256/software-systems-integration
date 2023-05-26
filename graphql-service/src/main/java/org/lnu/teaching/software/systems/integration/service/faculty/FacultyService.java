package org.lnu.teaching.software.systems.integration.service.faculty;

import org.lnu.teaching.software.systems.integration.service.common.CommonEntityService;
import org.lnu.teaching.software.systems.integration.entity.common.response.CreateMutationResponse;
import org.lnu.teaching.software.systems.integration.entity.common.response.MutationResponse;
import org.lnu.teaching.software.systems.integration.entity.faculty.Faculty;
import org.lnu.teaching.software.systems.integration.entity.faculty.error.status.FacultyCreateErrorStatus;
import org.lnu.teaching.software.systems.integration.entity.faculty.error.status.FacultyDeleteErrorStatus;
import org.lnu.teaching.software.systems.integration.entity.faculty.error.status.FacultyUpdateErrorStatus;
import org.springframework.core.io.buffer.DataBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FacultyService extends CommonEntityService<Faculty> {
    Mono<CreateMutationResponse<Faculty, FacultyCreateErrorStatus>> create(Faculty faculty);
    Mono<MutationResponse<FacultyUpdateErrorStatus>> update(Long id, Faculty faculty);
    Mono<MutationResponse<FacultyDeleteErrorStatus>> delete(Long id);
    Mono<String> findLogoUri(Faculty faculty);
    Flux<DataBuffer> readFacultyLogo(Long facultyId);
}
