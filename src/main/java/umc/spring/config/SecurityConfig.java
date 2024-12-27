package umc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity  // spring security 활성화 > 직접 작성한 보안 설정이 Spring security의 기본 설정보다 우선 적용
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests // http 요청에 대한 접근 제어 설정
                        .requestMatchers("/", "/home", "/signup", "/css/**", "/members/signup").permitAll() // 인증 없이 접근 가능
                        .requestMatchers("/admin/**").hasRole("ADMIN") // admin 권한 가진 사용자만 접근 가능
                        .anyRequest().authenticated() // 그외 모든 요청에 대해 인증 요구
                )
                .formLogin((form) -> form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
