package pl.patrykmuskala.CrmApplication.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.patrykmuskala.CrmApplication.Repository.UserRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/users**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/users**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/users**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.GET,"/api/salesmen**").hasAnyRole("HR", "ANALYST", "ADMIN")
                .antMatchers(HttpMethod.POST,"/api/salesmen**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/salesmen**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/salesmen**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/salesmen**").hasAnyRole("HR", "ADMIN")
                .antMatchers(HttpMethod.GET,"/api/orders**").hasAnyRole("BO", "BOMANAGER", "ANALYST", "ACCOUNTANT", "DESIGNER", "INSTALLER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/api/orders**").hasAnyRole("BO", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/orders**").hasAnyRole("BO", "ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/orders**").hasAnyRole("BO", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/orders**").hasAnyRole("BOMANAGER", "ADMIN")
                .antMatchers(HttpMethod.GET,"/api/customers**").hasAnyRole("BO", "BOMANAGER", "ANALYST", "ACCOUNTANT", "DESIGNER", "INSTALLER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/api/customers**").hasAnyRole("BO", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/customers**").hasAnyRole("BO", "ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/customers**").hasAnyRole("BO", "ADMIN", "DESIGNER")
                .antMatchers(HttpMethod.DELETE,"/api/customers**").hasAnyRole("BOMANAGER", "ADMIN")
                .antMatchers(HttpMethod.GET,"/api/inverters**").hasAnyRole("BO", "BOMANAGER", "DESIGNER", "INSTALLER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/api/inverters**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/inverters**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/inverters**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/inverters**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.GET,"/api/panels**").hasAnyRole("BO", "BOMANAGER", "DESIGNER", "INSTALLER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/api/panels**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/panels**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/panels**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/panels**").hasAnyRole("BOMANAGER", "DESIGNER", "ADMIN")
                .antMatchers("/api/addresses**").hasAnyRole("BOMANAGER", "ANALYST", "ADMIN")
                .anyRequest().authenticated();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
