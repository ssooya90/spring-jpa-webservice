package com.ssooya.webservice.config.auth.dto;

import com.ssooya.webservice.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {

	// 인증된 사용자 정보만 필요로 하는 클래스
	// 필요한 정보만 가져옴옴
	private String name;
	private String email;
	private String picture;

	public SessionUser(User user){
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = getPicture();
	}

}
