package org.lnu.teaching.software.systems.integration.service.common;

import graphql.GraphQLContext;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.lnu.teaching.software.systems.integration.entity.common.response.Connection;
import reactor.core.publisher.Mono;

public interface CommonEntityService<Entity> {
    Mono<Connection<Entity>> getConnection(DataFetchingFieldSelectionSet fs, int limit, long offset, GraphQLContext context);
    Mono<Entity> findById(Long id, DataFetchingFieldSelectionSet fs, GraphQLContext context);
}
