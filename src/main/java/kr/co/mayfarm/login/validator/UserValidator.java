package kr.co.mayfarm.login.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.mayfarm.login.domain.User;
import lombok.val;

public class UserValidator implements Validator {
	
	private final String REQUIRED = "error.required";

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		val user = (User) target;
		if (StringUtils.isBlank(user.getUsername()))
			errors.rejectValue("username", REQUIRED, REQUIRED);
		if (StringUtils.isBlank(user.getPassword()))
			errors.rejectValue("password", REQUIRED, REQUIRED);
	}

}
