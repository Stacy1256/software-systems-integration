package org.lnu.teaching.software.systems.integration.entity.common.column;

import lombok.Data;

@Data
public class ColumnValue {
    private final String column;
    private final Object value;
}
