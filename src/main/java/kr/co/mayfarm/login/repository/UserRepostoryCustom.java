package kr.co.mayfarm.login.repository;

import java.io.IOException;
import java.util.List;

import kr.co.mayfarm.login.domain.User;

public interface UserRepostoryCustom {
	List<User> findByPassword() throws IOException;
}
