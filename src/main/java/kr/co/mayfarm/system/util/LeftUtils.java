package kr.co.mayfarm.system.util;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import kr.co.mayfarm.system.domain.LeftResult;
import kr.co.mayfarm.system.domain.Menu;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeftUtils {
	
	private static String getToggleAttrs(boolean active, boolean menu) {
		return menu ?
			String.format(" data-toggle='submenu' aria-haspopup='true' aria-expanded='%s'", active ? "true" : "false") : "";
	}
	
	private static void findActiveMenusByParent(Map<String, Menu> findMenuMap, Menu menu, List<Menu> activeMenus) {
		if (menu == null) return;
		activeMenus.add(menu);
		findActiveMenusByParent(findMenuMap, findMenuMap.get(menu.getParentId()), activeMenus);
	}
	
	private static List<Menu> getActiveMenus(List<Menu> menus, String uri) {
		val path = Paths.get(uri);
		return menus.stream().filter(x -> {
			if (StringUtils.isBlank(x.getLink())) return false;
			return path.equals(Paths.get(x.getLink()));		
		}).collect(Collectors.toList());	
	}
	
	private static String getItem(List<Menu> menus, Menu menu, List<Menu> activeMenus) {
		StringBuilder sb = new StringBuilder();
		boolean isMenu = Menu.Type.MENU.equals(menu.getType()) ? true : false;
		boolean isActive = activeMenus.contains(menu);	
		String activeAttr = isActive ? " active" : "";
		String toggleAttrs = getToggleAttrs(isActive, isMenu);
		String submenuAttr = isMenu ? " nav-main-link-submenu" : "";	
		String link = isMenu ? "#" : menu.getLink();
		String openClass = isActive ? " open" : "";
		
		sb.append(String.format("<li class='nav-main-item%s'>", openClass));
		sb.append(String.format("<a class='nav-main-link%s%s'%s href='%s'>", 
				activeAttr, submenuAttr, toggleAttrs, link));
		if (!StringUtils.isBlank(menu.getIcon()))
			sb.append("<i class='" + menu.getIcon() + "'></i>");
		sb.append("<span class='nav-main-link-name'>" + menu.getName() + "</span>");
		sb.append("</a>");	
		if (isMenu) {
			sb.append("<ul class='nav-main-submenu'>");
			sb.append(getSubmenus(menus, menu, activeMenus));
			sb.append("</ul>");
		}
		sb.append("</li>");
		return sb.toString();
	}
	
	private static String getHeading(Menu menu) {
		return "<li class='nav-main-heading'>" + menu.getName() + "</li>";
	}
	
	private static String getSubmenus(List<Menu> menus, Menu menu, List<Menu> activeMenus) {
		StringBuilder sb = new StringBuilder();
		findByParent(menus, menu.getId()).stream().forEach(x -> sb.append(getItem(menus, x, activeMenus)));
		return sb.toString();
	}
	
	public static LeftResult createLeft(List<Menu> menus, String uri) {
		val findMenuMap = menus.stream()
				.collect(Collectors.toMap(Menu::getId, m -> m));
		val activeMenus = getActiveMenus(menus, uri);
 		if (activeMenus.size() > 0) findActiveMenusByParent(findMenuMap, 
 				findMenuMap.get(activeMenus.get(0).getParentId()), activeMenus);
 		
 		val supers = findByParent(menus, "__root__");
		StringBuilder sb = new StringBuilder();
		supers.forEach(x -> {
			if (Menu.Type.HEADING.equals(x.getType())) {
				sb.append(getHeading(x));
				findByParent(menus, x.getId()).
					forEach(y -> sb.append(getItem(menus, y, activeMenus)));
			}
			else sb.append(getItem(menus, x, activeMenus));
		});
		return LeftResult.of(sb.toString(), activeMenus);
	}
	
	private static List<Menu> findByParent(List<Menu> menus, String parentId) {
		return menus.stream().filter(x -> parentId.equals(x.getParentId()))
			.collect(Collectors.toList());
	}
	
}
