package org.lnu.teaching.software.systems.integration.util;

import org.lnu.teaching.software.systems.integration.entity.common.response.Connection;

import java.util.List;

public class ConnectionUtil {
    public static <T> Connection<T> createConnectionResponse(List<T> nodes) {
        return new Connection<>(nodes);
    }
}
