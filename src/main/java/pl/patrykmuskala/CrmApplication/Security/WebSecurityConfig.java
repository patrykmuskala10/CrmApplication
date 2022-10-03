package pl.patrykmuskala.CrmApplication.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .antMatchers("/", "/api/users").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/users**").hasAnyRole("HRManager", "Analyst", "Admin")
                .antMatchers(HttpMethod.POST,"/api/users**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.PUT,"/api/users**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.PATCH,"/api/users**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.DELETE,"/api/users**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.GET,"/api/salesmen**").hasAnyRole("HRManager", "Analyst", "Admin")
                .antMatchers(HttpMethod.POST,"/api/salesmen**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.PUT,"/api/salesmen**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.PATCH,"/api/salesmen**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.DELETE,"/api/salesmen**").hasAnyRole("HRManager", "Admin")
                .antMatchers(HttpMethod.GET,"/api/orders**").hasAnyRole("BO", "BOManager", "Analyst", "Accountant", "Designer", "Installer", "Admin")
                .antMatchers(HttpMethod.POST,"/api/orders**").hasAnyRole("BO", "Admin")
                .antMatchers(HttpMethod.PUT,"/api/orders**").hasAnyRole("BO", "Admin")
                .antMatchers(HttpMethod.PATCH,"/api/orders**").hasAnyRole("BO", "Admin")
                .antMatchers(HttpMethod.DELETE,"/api/orders**").hasAnyRole("BOManager", "Admin")
                .antMatchers(HttpMethod.GET,"/api/customers**").hasAnyRole("BO", "BOManager", "Analyst", "Accountant", "Designer", "Installer", "Admin")
                .antMatchers(HttpMethod.POST,"/api/customers**").hasAnyRole("BO", "Admin")
                .antMatchers(HttpMethod.PUT,"/api/customers**").hasAnyRole("BO", "Admin")
                .antMatchers(HttpMethod.PATCH,"/api/customers**").hasAnyRole("BO", "Admin", "Designer")
                .antMatchers(HttpMethod.DELETE,"/api/customers**").hasAnyRole("BOManager", "Admin")
                .antMatchers(HttpMethod.GET,"/api/inverters**").hasAnyRole("BO", "BOManager", "Designer", "Installer", "Admin")
                .antMatchers(HttpMethod.POST,"/api/inverters**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.PUT,"/api/inverters**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.PATCH,"/api/inverters**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.DELETE,"/api/inverters**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.GET,"/api/panels**").hasAnyRole("BO", "BOManager", "Designer", "Installer", "Admin")
                .antMatchers(HttpMethod.POST,"/api/panels**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.PUT,"/api/panels**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.PATCH,"/api/panels**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers(HttpMethod.DELETE,"/api/panels**").hasAnyRole("BOManager", "Designer", "Admin")
                .antMatchers("/api/addresses**").hasAnyRole("BOManager", "Analyst", "Admin")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().permitAll();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("Admin")
                        .build();
        UserDetails hr =
                User.withDefaultPasswordEncoder()
                        .username("hr")
                        .password("password")
                        .roles("HRManager")
                        .build();
        UserDetails bo =
                User.withDefaultPasswordEncoder()
                        .username("bo")
                        .password("password")
                        .roles("BO")
                        .build();
        UserDetails bomanager =
                User.withDefaultPasswordEncoder()
                        .username("bomanager")
                        .password("password")
                        .roles("BOManager")
                        .build();
        UserDetails analyst =
                User.withDefaultPasswordEncoder()
                        .username("analyst")
                        .password("password")
                        .roles("Analyst")
                        .build();
        UserDetails accountant =
                User.withDefaultPasswordEncoder()
                        .username("accountant")
                        .password("password")
                        .roles("Accountant")
                        .build();
        UserDetails designer =
                User.withDefaultPasswordEncoder()
                        .username("designer")
                        .password("password")
                        .roles("Designer")
                        .build();
        UserDetails installer =
                User.withDefaultPasswordEncoder()
                        .username("intaller")
                        .password("password")
                        .roles("Installer")
                        .build();

        users.add(admin);
        users.add(hr);
        users.add(bo);
        users.add(bomanager);
        users.add(accountant);
        users.add(analyst);
        users.add(designer);
        users.add(installer);

        return new InMemoryUserDetailsManager(users);
    }
}
