package ptr.marius.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Value("${our.very.secret.key}")
    private String key;

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
