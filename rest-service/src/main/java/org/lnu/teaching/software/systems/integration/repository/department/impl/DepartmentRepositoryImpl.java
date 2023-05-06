package org.lnu.teaching.software.systems.integration.repository.department.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.repository.department.DepartmentRepository;
import org.lnu.teaching.software.systems.integration.entity.department.DepartmentEntity;
import org.lnu.teaching.software.systems.integration.entity.faculty.FacultyEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static final String INSERT_DEPARTMENT_QUERY = """
            INSERT INTO departments (
                name,
                faculty_id,
                email,
                phone,
                info
            ) VALUES (
                :name,
                :facultyId,
                :email,
                :phone,
                :info
            )
            """;

    private static final String SELECT_DEPARTMENT_ITEMS_QUERY = """
            SELECT
                d.id,
                d.name,
                faculty_id,
                f.name faculty_name
            FROM departments d
            JOIN faculties f ON (f.id = d.faculty_id)
            """;

    private static final RowMapper<DepartmentEntity> DEPARTMENT_ITEM_ROW_MAPPER = (rs, rowNum) -> {
        DepartmentEntity entity = new DepartmentEntity();

        entity.setId(rs.getObject("id", Long.class));
        entity.setName(rs.getString("name"));

        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setId(rs.getObject("faculty_id", Long.class));
        facultyEntity.setName(rs.getString("faculty_name"));
        entity.setFaculty(facultyEntity);

        return entity;
    };

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public DepartmentEntity create(DepartmentEntity department) {
        SqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("name", department.getName())
                .addValue("facultyId", department.getFaculty().getId())
                .addValue("email", department.getEmail())
                .addValue("phone", department.getPhone())
                .addValue("info", department.getInfo());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(INSERT_DEPARTMENT_QUERY, sqlParameters, keyHolder);

        Long id = (Long) keyHolder.getKeys().get("id");
        department.setId(id);

        return department;
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return jdbcTemplate.query(SELECT_DEPARTMENT_ITEMS_QUERY, DEPARTMENT_ITEM_ROW_MAPPER);
    }
}
