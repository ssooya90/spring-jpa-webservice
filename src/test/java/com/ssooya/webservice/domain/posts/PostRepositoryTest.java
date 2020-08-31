package com.ssooya.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@After // 테스트 후 작동 어노테이션
	public void cleanup() {
		postRepository.deleteAll();
	}

	@Test
	public void board_load() {
		//given 변수 선언
		String title = "테스트 게시글";
		String content = "테스트 본문";

		postRepository.save(Posts.builder()
				.title(title)
				.content(content)
				.author("ssooya90@naver.com")
				.build());

		//when
		List<Posts> postsList = postRepository.findAll();

		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}

	@Test
	public void BaseTimeEntity_reg() {

		//given
		LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
		postRepository.save(Posts.builder()
				.title("title")
				.content("content")
				.author("author")
				.build());

		//when
		List<Posts> postsList = postRepository.findAll();

		// then
		Posts posts = postsList.get(0);

		System.out.println(">>>>>>>>>>>> createDate=" + posts.getCreateDate() +", modifiedDate =" + posts.getModifiedDate());

		assertThat(posts.getCreateDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);
	}

}
