package ptr.marius.security.config.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import ptr.marius.security.entities.Authority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return null;
    }
}
