package org.lnu.teaching.software.systems.integration.dto.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ValueDto<T> implements Serializable {
    private final T value;
}
