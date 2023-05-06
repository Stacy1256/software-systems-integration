package org.lnu.teaching.software.systems.integration.dto.common;

import lombok.Data;

@Data
public class ValueDto<T> {
    private final T value;
}
