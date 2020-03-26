package kr.co.mayfarm.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.mayfarm.system.domain.Menu;
import kr.co.mayfarm.system.repository.MenuRepository;
import kr.co.mayfarm.system.service.MenuService;
import kr.co.mayfarm.system.util.LeftUtils;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuInterceptor extends HandlerInterceptorAdapter {
	
	private final MenuService menuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		val menus = menuService.findAll();
		request.setAttribute("leftResult", LeftUtils.createLeft(menus, request.getRequestURI()));
		return true;
	}
	
}
