package org.springframework.samples.validator;


import org.springframework.samples.controller.MemberRegistRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventFormStep2Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberRegistRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		MemberRegistRequest regReq = (MemberRegistRequest) target;
		
		String length = regReq.getTime(); 
		if (length == null || length.trim().isEmpty()) {
			errors.rejectValue("time", "required");
		}
		else {
			try { 
				if (Integer.parseInt(length) > 30)
					errors.rejectValue("time", "longtime");
			} catch (NumberFormatException e) {
				errors.rejectValue("time", "invalidNumber");
			}
		}
		
		if (regReq.getRequirements().length() > 50)
			errors.rejectValue("requirements", "longrequire");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "song", "required");
		ValidationUtils.rejectIfEmpty(errors, "type", "required");
	
	}
}