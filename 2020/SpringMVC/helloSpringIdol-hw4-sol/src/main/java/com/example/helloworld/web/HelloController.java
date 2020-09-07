package com.example.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.helloworld.domain.Message;
import com.example.helloworld.service.HelloService;
import com.example.springidol.Performer;
import com.example.springidol.SpringIdol;

@Controller
public class HelloController {
	
	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}
	
	@Autowired
	private HelloService helloSvc;

	@RequestMapping("/hello.do")
	public ModelAndView hello(
		@RequestParam(value="name", required=false) String name) {
		String greeting = helloSvc.getGreeting();
		if (name != null) greeting = greeting + name;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", greeting);
		return mav;
	}

	@RequestMapping("/hello.do/{id}")
	public ModelAndView helloIdol(@PathVariable("id") String id) {
		Message message = helloSvc.createMessage(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloIdol");
		mav.addObject("message", message);
		return mav;
	}

	@RequestMapping("/perform/{id}")
	public ModelAndView perform(@PathVariable("id") String id) {
		Performer p = helloSvc.getPerformer(id);
		ModelAndView mav = new ModelAndView("perform");
		mav.addObject("performer", p);
		return mav;
	}
}
