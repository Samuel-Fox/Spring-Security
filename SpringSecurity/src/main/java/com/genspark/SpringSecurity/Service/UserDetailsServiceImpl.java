package com.genspark.SpringSecurity.Service;

import com.genspark.SpringSecurity.Dao.UserRepository;
import com.genspark.SpringSecurity.Entity.User;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(
			user.getUsername(),
			user.getPassword(),
			user.isEnabled(),
			true,
			true,
			true,
			getAuthorities(user.getUsername()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String username) {
		System.out.println(userRepository.findByUsername(username).getUsername());
		System.out.println(userRepository.findByUsername(username).getPassword());
		System.out.println(userRepository.findByUsername(username).getRoles());
		System.out.println(userRepository.findByUsername(username).isEnabled());
		return Collections.singletonList(new SimpleGrantedAuthority(userRepository.findByUsername(username).getRoles()));
	}
}
