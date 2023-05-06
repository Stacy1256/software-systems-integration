package org.lnu.teaching.software.systems.integration.dto.faculty;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseFacultyDto implements Serializable {
    private String name;
    private String website;
    private String email;
    private String phone;
    private String address;
    private String info;
}
