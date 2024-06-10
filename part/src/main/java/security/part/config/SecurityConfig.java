package security.part.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    public UserDetailsService userDetailsService(){
        UserDetails shivanshu = User.builder()
                .username("shivanshu")
                .password("shivanshu")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(shivanshu);
    }
}
