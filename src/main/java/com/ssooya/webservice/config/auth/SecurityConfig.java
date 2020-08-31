package com.ssooya.webservice.config.auth;

import com.ssooya.webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity	// Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http.
				csrf().disable()
				.headers().frameOptions().disable()	// H2 접근하기 위한 옵션 미사용
				.and()

					.authorizeRequests()	// URL별 관리를 설정하는 옵션의 시작점

					// antMatchers란 권한관리 대상을 지정하는 옵션션
					.antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
					.antMatchers("/api/v1/**").hasRole(Role.USER.name())
					.anyRequest().authenticated()	// 설정된 값 이외 나머지 URL를 나타냄
				.and()
					.logout()
						.logoutSuccessUrl("/")
				.and()
					.oauth2Login()
						.userInfoEndpoint()
							.userService(customOAuth2UserService);


	}

}
