package kr.co.mayfarm.system.service;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.mayfarm.system.domain.LeftResult;
import kr.co.mayfarm.system.domain.Menu;
import kr.co.mayfarm.system.repository.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {
	
	private final MenuRepository menuRepo;
	
	public boolean isEmpty() {
		return menuRepo.count() == 0 ? true : false;
	}
	
	public Menu save(Menu menu) {
		return menuRepo.save(menu);
	}
	
	public List<Menu> findAll() {
		val iter = menuRepo.findAll(
			new Sort(Sort.Direction.ASC, "parentId").and(new Sort(Sort.Direction.ASC, "order")));
		return IterableUtils.toList(iter);
	}
	
}
