package kr.co.mayfarm.login.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kr.co.mayfarm.login.controller.LoginController;
import lombok.RequiredArgsConstructor;

@RunWith(SpringRunner.class)
//@WebMvcTest(LoginController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/zz")
				.param("password", "password")
				.param("username", "username"))
			.andExpect(model().hasNoErrors())
			.andExpect(status().isOk()) 
			.andExpect(model().attribute("myname", "jglee"))
			.andExpect(view().name("index"))
			.andDo(print());
	}

}
