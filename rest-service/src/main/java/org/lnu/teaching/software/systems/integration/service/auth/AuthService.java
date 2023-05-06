package org.lnu.teaching.software.systems.integration.service.auth;

import org.lnu.teaching.software.systems.integration.annotation.Auth;
import org.lnu.teaching.software.systems.integration.dto.user.UserCredentials;

public interface AuthService {
    void login(UserCredentials userCredentials);
    void verifyAuthority(Auth auth);
}
