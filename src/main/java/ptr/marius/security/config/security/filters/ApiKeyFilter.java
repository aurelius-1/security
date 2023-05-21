package ptr.marius.security.config.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ptr.marius.security.config.security.authentication.ApiKeyAuthentication;
import ptr.marius.security.config.security.managers.ApiKeyAuthenticationManager;

import java.io.IOException;

@Component
@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String key = "secrett";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var requestKey = request.getHeader("x-api-key");

        if (requestKey == null || "null".equals(requestKey)) {
            filterChain.doFilter(request, response);
        }

        var auth = new ApiKeyAuthentication();

        try {
            ApiKeyAuthenticationManager manager = new ApiKeyAuthenticationManager(key);
            var a = manager.authenticate(auth);

            if (a.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(a);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }


    }
}
