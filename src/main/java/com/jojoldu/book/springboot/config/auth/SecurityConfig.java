package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService CustomOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    // 권한 관리 대상을 지정하는 옵션
                    .antMatchers("/","/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()   // "/" 등 지정된 URL들은 permitAll()옵션을 통해 전체 열람 권한을 주었다.
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())    // "/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 하였다.
                    .anyRequest().authenticated()   // 나머지 URL들은 모두 인증된 사용자들에게만 허용(로그인한 사용자)
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담음
                            .userService(CustomOAuth2UserService);
    }
}
