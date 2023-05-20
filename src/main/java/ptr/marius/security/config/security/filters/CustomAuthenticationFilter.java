package ptr.marius.security.config.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ptr.marius.security.config.security.authentication.CustomAuthentication;
import ptr.marius.security.config.security.managers.CustomAuthenticationManager;

import java.io.IOException;

//@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //1. create an authentication object which is not authenticated
        //2. delegate the authentication to the manager
        //3. get back the authentication from the manager
        //4. if the object is authenticated then send the request to the next filter in the chain

        String key = String.valueOf(request.getHeader("key"));

        CustomAuthentication customAuthentication =
                new CustomAuthentication(false, key);

        var a = customAuthenticationManager.authenticate(customAuthentication);

        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }


    }
}
