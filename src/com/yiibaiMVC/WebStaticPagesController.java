package com.yiibaiMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebStaticPagesController {
	@RequestMapping(value = "/indexStatic", method = RequestMethod.GET)
	public String indexStatic() {
		return "indexStatic";
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirectStatic() {
		return "redirect:/pages/final.html";
	}
}