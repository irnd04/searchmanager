package kr.co.mayfarm.system.domain;

import java.util.List;

import lombok.Data;

@Data(staticConstructor = "of")
public class LeftResult {
	private final String left;
	private final List<Menu> activeMenus;
}
