package org.lnu.teaching.software.systems.integration.util;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.lnu.teaching.software.systems.integration.constants.ModelConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FieldSelectionUtil {
    public static List<String> ID_FIELD_ONLY = List.of(ModelConstants.ID);

    public static List<String> getSelectedDbFields(List<String> selectableDbFields, DataFetchingFieldSelectionSet fs) {
        List<String> dbFields = new ArrayList<>();
        dbFields.add(ModelConstants.ID);

        selectableDbFields.forEach(declaredField -> {
            if (fs.contains(declaredField)) {
                dbFields.add(declaredField);
            }
        });

        return dbFields;
    }

    public static Set<String> getSelectedDbFieldSet(List<String> selectableDbFields, DataFetchingFieldSelectionSet fs) {
        Set<String> dbFields = new HashSet<>();
        dbFields.add(ModelConstants.ID);

        selectableDbFields.forEach(declaredField -> {
            if (fs.contains(declaredField)) {
                dbFields.add(declaredField);
            }
        });

        return dbFields;
    }
}
