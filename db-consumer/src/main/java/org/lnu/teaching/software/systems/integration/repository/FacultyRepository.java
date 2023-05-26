package org.lnu.teaching.software.systems.integration.repository;

import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.entity.Faculty;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FacultyRepository {
    private static final String INSERT_FACULTY_QUERY = """
            INSERT INTO faculties (
                name,
                website,
                email,
                phone,
                address,
                info
            ) VALUES (
                :name,
                :website,
                :email,
                :phone,
                :address,
                :info
            )
            """;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public Faculty create(Faculty faculty) {
        SqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("name", faculty.getName())
                .addValue("website", faculty.getWebsite())
                .addValue("email", faculty.getEmail())
                .addValue("phone", faculty.getPhone())
                .addValue("address", faculty.getAddress())
                .addValue("info", faculty.getInfo());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(INSERT_FACULTY_QUERY, sqlParameters, keyHolder);

        Long facultyId = (Long) keyHolder.getKeys().get("id");
        faculty.setId(facultyId);

        return faculty;
    }
}
