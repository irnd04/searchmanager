package kr.co.mayfarm.login.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.mayfarm.login.domain.User;
import kr.co.mayfarm.login.service.UserService;
import lombok.val;
import lombok.var;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	private final String USERNAME = "testUser....";
	private final String PASSWORD = "0000";
	
	@Before
	public void setup() throws Exception {
		userService.createUser(USERNAME, PASSWORD);
	}
	
	@After
	public void close() {
		assertThat(userRepo.findByUsername(USERNAME)).isNull();
		userRepo.deleteByUsername(USERNAME);
		assertThat(userRepo.findByUsername(USERNAME)).isNull();
	}
	
	
	@Test
	public void test() throws IOException {
		// findByUsername
		var user = userRepo.findByUsername(USERNAME);
		assertThat(user).isNotNull();
		
		// deleteById;
		userRepo.deleteById(user.getId());
		
		// findByUsername
		user = userRepo.findByUsername(user.getUsername());
		assertThat(user).isNull();
		
		val users = userRepo.findByPassword();
	}

}
