package ptr.marius.security.config.security.managers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ptr.marius.security.config.security.providers.CustomAuthenticationProvider;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider provider;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (provider.supports(authentication.getClass())) {
            return provider.authenticate(authentication);
        }

        throw new BadCredentialsException("Bad credentials");
    }
}