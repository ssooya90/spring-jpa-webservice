package com.ssooya.webservice.web;

import com.ssooya.webservice.config.auth.LoginUser;
import com.ssooya.webservice.config.auth.dto.SessionUser;
import com.ssooya.webservice.service.PostsService;
import com.ssooya.webservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postsService;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user, HttpServletRequest request) {

		model.addAttribute("posts",postsService.findAllDesc());

		if(user != null){ model.addAttribute("userName",user.getName()); }

		String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

		model.addAttribute("url",url);


		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave(){
		return "posts-save";
	}


	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);

		return "posts-update";
	}
}
