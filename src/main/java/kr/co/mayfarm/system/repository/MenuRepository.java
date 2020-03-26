package kr.co.mayfarm.system.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.mayfarm.system.domain.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, String> {
	Menu findByName(String string);
	Iterable<Menu> findAll(Sort sort);
}
