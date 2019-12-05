package by.gsu.pms.lr12.domain;

import org.springframework.security.core.GrantedAuthority;

public class DefaultRole implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "USER";
    }
}
