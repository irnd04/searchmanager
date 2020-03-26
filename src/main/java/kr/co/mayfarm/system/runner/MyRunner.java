package kr.co.mayfarm.system.runner;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.mayfarm.system.domain.Menu;
import kr.co.mayfarm.system.properties.ElasticsearchProperties;
import kr.co.mayfarm.system.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyRunner implements ApplicationRunner {
	
	private final ElasticsearchProperties props;
	private final MenuService menuService;
	private final ObjectMapper mapper;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info(props.toString());
		if (menuService.isEmpty()) {
			val menus = mapper.readValue(ResourceUtils.getFile("classpath:menu.json"), Menu[].class);
			Arrays.stream(menus).forEach(x -> menuService.save(x));
		}
	}

}
