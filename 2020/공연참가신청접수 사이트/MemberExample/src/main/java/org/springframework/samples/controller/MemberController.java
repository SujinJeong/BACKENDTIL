package org.springframework.samples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.model.MemberInfo;
import org.springframework.samples.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/index")
	public String members(Model model) {
		List<MemberInfo> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "index";
	}

}
