package com.ssooya.webservice.domain.posts;

import com.ssooya.webservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가 public Posts(){}와 같은 효과
@Entity
public class Posts extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false) // String Db 기본값은 varchar2 255
	private String content;

	private String author;	// Entity에서 @column을 생략하여도 기본값으로 생성됨, 단 명시할 경우 옵션 사용 가능

	@Builder
	public Posts(String title, String content, String author){
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public void update(String title, String content){
		this.title = title;
		this.content = content;
	}
}
