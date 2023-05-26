package org.lnu.teaching.software.systems.integration.service.user;

import org.lnu.teaching.software.systems.integration.dto.user.UserCreateDto;
import org.lnu.teaching.software.systems.integration.dto.user.UserDto;
import org.lnu.teaching.software.systems.integration.dto.user.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserDto create(UserCreateDto userDto);
    List<UserDto> findAll();
    UserDto find(Long id);
    void update(Long id, UserUpdateDto userDto);
    void delete(Long id);
}
