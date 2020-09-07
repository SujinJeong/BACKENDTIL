package org.springframework.samples.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.samples.model.MemberInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object obj) throws Exception {
		
		 // session 객체 가져옴
	      HttpSession session = request.getSession();
	      // login 처리 담당 사용자 정보를 가져옴
	      obj = session.getAttribute("login");
	      MemberInfo m = (MemberInfo) obj;   //login세션에 저장되어 있는 정보 가져옴
	      session.setAttribute("defaultEmail", request.getParameter("email"));
	      
	      
	   // 로그인이 되어있지 않거나, 다른 계정으로 로그인 되어있으면 다시 로그인 폼으로 redirect
	      if(obj == null || !request.getParameter("email").equals(m.getEmail())) {
	    	  String dfltemail = (String) request.getParameter("email");
	    	  response.sendRedirect(request.getContextPath()+"/login?id=" + dfltemail);
	         return false;
	      }
		return true;
	}

}