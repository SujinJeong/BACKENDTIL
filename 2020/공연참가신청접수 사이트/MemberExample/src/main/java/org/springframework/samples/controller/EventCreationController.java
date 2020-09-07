package org.springframework.samples.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.model.Address;
import org.springframework.samples.model.MemberInfo;
import org.springframework.samples.service.MemberService;
import org.springframework.samples.validator.EventFormStep1Validator;
import org.springframework.samples.validator.EventFormStep2Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("regReq")
public class EventCreationController {

	private static final String EVENT_CREATION_STEP1 = "event/creationStep1";
	private static final String EVENT_CREATION_STEP2 = "event/creationStep2";
	private static final String EVENT_CREATION_STEP3 = "event/creationStep3";
	private static final String EVENT_CREATION_DONE = "event/creationDone";
	
	@Autowired
	private MemberService memberService;
	
	// 객체를 생성하여 session에 저장
	@ModelAttribute("regReq")
	public MemberRegistRequest formBacking(HttpServletRequest request) {  
	      if (request.getMethod().equalsIgnoreCase("GET")) {  
	         MemberRegistRequest memRegReq = new MemberRegistRequest();  
	         Address address = new Address();
	         // 도시 값 default 설정
	         address.setCity("서울");
	         memRegReq.setAddress(address);
	         // 공연시간 default값 설정
	         memRegReq.setTime("20");
	         return memRegReq;
	      } else {   //POST request일 경우
	         return new MemberRegistRequest();   //command 객체 생성
	      }
	}

	// 첫번째 폼 띄워주기
	@RequestMapping("/newevent/step1")
	public String step1() {
		return EVENT_CREATION_STEP1;
	}
	
	
	// 첫번째 폼 validation 후 두번째 폼 띄워주기
	@RequestMapping(value = "/newevent/step2", method = RequestMethod.POST)
	public String step2(@ModelAttribute("regReq") MemberRegistRequest formData, BindingResult result) {
		// 첫번째 폼 validator 실행
		new EventFormStep1Validator().validate(formData, result);
		// 중복되는 이메일이 있는지 확인
		if(memberService.isMemberInfo(formData.getEmail())) {
			result.rejectValue("email", "sameEmail");
		}
		if (result.hasErrors())
			return EVENT_CREATION_STEP1;
		return EVENT_CREATION_STEP2;
	}
		
	// Step 3에서 Step 2로 되돌아오는 경우
	@RequestMapping(value = "/newevent/step2", method = RequestMethod.GET)
	public String step2FromStep3(@ModelAttribute("regReq") MemberRegistRequest formData) {
		return EVENT_CREATION_STEP2;
	}

	// 두번째 폼 validation 후 세번째 폼 띄워주기
	@RequestMapping(value = "/newevent/step3", method = RequestMethod.POST)
	public String step3(@ModelAttribute("regReq") MemberRegistRequest formData, BindingResult result) {
		// 두번째 폼 validator 실행
		new EventFormStep2Validator().validate(formData, result);
		if (result.hasErrors())
			return EVENT_CREATION_STEP2;
		return EVENT_CREATION_STEP3;
	}

	@RequestMapping(value = "/newevent/done", method = RequestMethod.POST)
	public String done( @ModelAttribute("regReq") MemberRegistRequest formData, SessionStatus sessionStatus, Model model) {
		// 모든 입력과 확인이 완료되었을 때 공연신청 일시와 함께 출력	
		formData.setRegTime(new Date());
	
		// 접수 처리 후 hashmap에 저장해 공연 일정을 출력해주기 위한 부분
		memberService.registerNewMember(formData);
		// 세션 종료
	    sessionStatus.setComplete();
	    return EVENT_CREATION_DONE;
	}

	//정보 조회를 위한 api
	@RequestMapping("/members/get")
	public String memberDetail(@RequestParam("email") String email, Model model) {
		// email로 member의 구체적인 정보 조회하기
		MemberInfo mi = memberService.getMemberInfo(email);
		model.addAttribute("member", mi);
		return "member/memberDetail";
	}
	
	// 삭제 기능을 위한 api
	@RequestMapping("/members/delete")
		public String deleteMember(@RequestParam("email") String email, Model model) {
			// member 정보 삭제
			memberService.removeMember(email);
			return "member/memberRemove";
		}

}
