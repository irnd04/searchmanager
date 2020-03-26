package kr.co.mayfarm.login.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.mayfarm.login.domain.User;
import kr.co.mayfarm.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.var;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	
	public boolean existsUser(String username) {
		val user = userRepo.findByUsername(username);
		return user == null ? false : true; 
	}
	
	public synchronized User createUser(String username, String password) throws Exception {
		if (existsUser(username)) throw new Exception(username + " 같은 이름의 사용자가 존재합니다.");
		password = passwordEncoder.encode(password);
		var user = User.builder()
				.username(username)
				.password(password)
				.build();
		user = userRepo.save(user);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userRepo.findByUsername(username);
		user = Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException(username));
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), getAuthorities());
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
