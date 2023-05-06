package org.lnu.teaching.software.systems.integration.entity.projection;

public interface UserAuthDataProjection {
    String getUsername();
    boolean getIsAdmin();
    String getPasswordHash();
}
