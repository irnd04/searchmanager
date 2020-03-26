package kr.co.mayfarm.login.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.mayfarm.login.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>, UserRepostoryCustom {
	User findByUsername(String username);
	void deleteByUsername(String username);
}
