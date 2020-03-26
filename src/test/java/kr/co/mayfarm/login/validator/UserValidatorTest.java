package kr.co.mayfarm.login.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.stream.Collectors;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.mayfarm.login.domain.User;
import lombok.val;
import lombok.var;

@RunWith(SpringRunner.class)
public class UserValidatorTest {
	private Validator validator;
	
	@Before
	public void createValidator() {
		try (val validatorFactory = Validation.buildDefaultValidatorFactory()) {
			validator = validatorFactory.getValidator();	
		}
	}
	
	@Test
	public void test() {
		var user = User.builder().build();
		val constraintViolations = validator.validate(user);
		assertThat(constraintViolations).hasSize(2);
		val a = new HashSet<>(java.util.Arrays.asList("username", "password"));
		val b = constraintViolations.stream().map(s -> s.getPropertyPath().toString())
			.collect(Collectors.toSet());
		assertThat(a).isEqualTo(b);	
	}

}
