package com.ssooya.webservice.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column
	private String picture;

	// JPA로 데이터베이스로 저장할 때 ENUM TYPE 지정
	// 디폴트는 int
	// 숫자로 저장되면 데이터베이스로 확인할 때 그 값이 무슨 코드인지 알수가 없음
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;

	@Builder
	public User(String name, String email, String picture, Role role){
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.role = role;
	}

	public User update(String name, String picture){
		this.name = name;
		this.picture = picture;
		return this;
	}

	public String getRoleKey(){
		return this.role.getKey();
	}




}
