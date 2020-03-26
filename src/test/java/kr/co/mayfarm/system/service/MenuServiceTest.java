package kr.co.mayfarm.system.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kr.co.mayfarm.system.domain.LeftResult;
import lombok.val;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MenuServiceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MenuService menuService;

	@Test
	public void test() throws Exception {
		
//		val lr = LeftResult.of("", new ArrayList<kr.co.mayfarm.system.domain.Menu>());
//		when(menuService.createLeft("/"))
//			.thenReturn(lr);
//		
//		mockMvc.perform(get("/"))
//			.andExpect(status().isOk())
//			.andExpect(request().attribute("leftResult", is(equalTo(lr))));
	}

}
