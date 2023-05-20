package ptr.marius.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Value("${our.very.secret.key}")
    private String key;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
//                    .anyRequest().authenticated() //endpoint level authorization
//                .anyRequest().permitAll()
//                .anyRequest().denyAll()
//                .anyRequest().hasAuthority("write")
//                .anyRequest().hasAnyAuthority("read", "write")
//                .anyRequest().hasRole("ADMIN")
//                .anyRequest().hasAnyRole("ADMIN", "MANAGER")
//                .anyRequest().access("isAuthenticated() and hasAuthority('read')")
//                .anyRequest().hasRole("ADMIN")
                .and().build();


        //matcher method + authorization rule
        // 1. which matcher methods should you use and how ( anyRequest(), antMatchers(), mvcMatchers(), regexMatchers() )
        // 2. how to apply different authorization rules
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        var uds = new InMemoryUserDetailsManager();
//
//        var u1 = User.withUsername("bill")
//                .password(passwordEncoder().encode("12345"))
//                .authorities("read")
//                .roles("ADMIN")
//                .build();
//
//        var u2 = User.withUsername("john")
//                .password(passwordEncoder().encode("12345"))
//                .authorities("write")
//                .roles("MANAGER")
//                .build();
//
//        uds.createUser(u1);
//
//        uds.createUser(u2);
//
//        return uds;
//    }

//    private final CustomAuthenticationFilter customAuthenticationFilter;
//    private final ApiKeyFilter apiKeyFilter;

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.httpBasic()
//                .and()
//                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
////                .addFilterAt(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
////                .addFilterAt(customAuthenticationFilter, BasicAuthenticationFilter.class)
//                .authorizeHttpRequests().anyRequest().authenticated()
//                .and()
//                //.and().authenticationManager() or by adding a bean of type AuthMng
//                //.and().authenticationProvider() it doesn't override the AP, it add
//                .build();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests().anyRequest().authenticated()  // don't worry about this
//                .and().build();
////    }

    //lesson learnt --- custom authentication overwrites password encoded authentication!!!
    //implementing a
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
