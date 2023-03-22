package com.eros.security;

import java.util.ArrayList;

import com.eros.config.WebSecurityConfig;
import com.eros.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

	private final UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = usuarioService.getByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("UserName not found");
		}

		if ("Eros".equals(username)) {
			return new User("Eros", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
		} else {
			return new User(user.getName(), user.getPassword(), new ArrayList<>());
		}


	}
}
