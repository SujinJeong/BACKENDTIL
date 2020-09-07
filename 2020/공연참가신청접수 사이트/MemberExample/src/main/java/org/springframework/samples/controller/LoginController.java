package org.springframework.samples.controller;

import org.springframework.samples.model.MemberInfo;
import org.springframework.samples.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.validator.LoginCommandValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private String formViewName = "member/login";
	@Autowired
	private MemberService memberService;

	// 로그인 폼 띄우기
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String form(HttpServletRequest request) {	
	return formViewName;
	}
	
	// Model Attribute인 LoginCommand를 위한 formBacking
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}

	// 로그인 처리
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String submit(@ModelAttribute("loginCommand") LoginCommand loginCommand, 
			HttpSession session,  Errors errors) {
		if (session.getAttribute("login") != null)
			//기존에 login이란 세션 값이 존재하면 session에서 login정보 삭제                                                                                                                                  
			session.removeAttribute("login");
		
		// Login form 검증
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return formViewName;
		}
		
		
		  //로그인이 성공하면 MemberInfo 객체 반환
	      MemberInfo m = memberService.getMemberInfo(loginCommand.getEmail());
	      // 멤버 정보가 존재하지 않거나 패스워드가 일치하지 않을 떄
	      if ( m != null && (loginCommand.getPassword()).equals(m.getPassword())) {
	    	//세션에 login이름으로 memberInfo객체 저장
	    	  session.setAttribute("login", m); 
	         return "redirect:/index";
	      } else {   //로그인 실패시
	    	  //암호가 일치하지 않을 때 오류 메세지 출력
	           errors.reject("invalidIdOrPassword", new Object[] { loginCommand
						.getEmail() }, null);
	         return formViewName;
	      }
		
	}
	
}