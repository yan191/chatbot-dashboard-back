package br.com.fatec.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fatec.dashboard.security.AuthorityRepository;
import br.com.fatec.dashboard.security.User;
import br.com.fatec.dashboard.security.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void save(User usuario) {
		User user = new User();
		user.setUsername(usuario.getUsername());
	    user.setPassword(passwordEncoder.encode(usuario.getPassword()));
	    user.setAuthorities(authorityRepository.findAll());
	    user.setNomeCompleto(usuario.getNomeCompleto());
	    user.setEmail(usuario.getEmail());
	    userRepository.save(user);
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
