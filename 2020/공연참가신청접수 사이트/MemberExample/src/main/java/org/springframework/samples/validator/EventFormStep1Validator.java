package org.springframework.samples.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.samples.controller.MemberRegistRequest;
import org.springframework.samples.model.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventFormStep1Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberRegistRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MemberRegistRequest regReq = (MemberRegistRequest) target;
		
		// 필수항목인 이메일 필드 입력되었는지 확인
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty())
			errors.rejectValue("email", "required");
		else {
			//이메일 패턴 확인
			if(regReq.getEmail().matches("([0-9a-zA-Z_\\.-]+)@([0-9a-zA-Z_-]+)(\\.[0-9a-zA-Z_-]+){1,2}") == false)
					errors.rejectValue("email", "invalidEmail");
		}

		// 필수항목인 이름 필드 입력되었는지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		if (regReq.getPhonenum() == null || regReq.getPhonenum().trim().isEmpty())
			errors.rejectValue("phonenum", "required");
		else {
			// 전화번호 패턴 확인
			Pattern p1 = Pattern.compile("^01\\d{1}-\\d{3,4}-\\d{4}$");
			Matcher m1 = p1.matcher(regReq.getPhonenum());
			if (!m1.find())
				errors.rejectValue("phonenum", "invalidPhonenum");
		}
		
		if (regReq.hasPassword()) {
			// 패스워드 길이 확인
			if (regReq.getPassword().length() < 6)
				errors.rejectValue("password", "shortPassword");
			else if (!regReq.isSamePasswordConfirmPassword())
				errors.rejectValue("confirmPassword", "notSame");
		}
		
		Address address = regReq.getAddress();
		if (address != null && !address.getZipcode().trim().isEmpty()) {			
			if (address.getZipcode().matches("\\d{5}") == false) {
				errors.pushNestedPath("address");	
				errors.rejectValue("zipcode", "invalidZipcode");	// address.zipcode에 해당
				errors.popNestedPath();			
			}
		}
	}
}