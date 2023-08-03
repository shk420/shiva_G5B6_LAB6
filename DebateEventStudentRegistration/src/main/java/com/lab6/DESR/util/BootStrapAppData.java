package com.lab6.DESR.util;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lab6.DESR.Model.Role;
import com.lab6.DESR.Model.User;
import com.lab6.DESR.Repository.UserRepository;



@Configuration
public class BootStrapAppData {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		
		User shiva = new User("shiva", this.passwordEncoder.encode("welcome"));
		User ravi = new User("ravi", this.passwordEncoder.encode("welcome"));
		User harshi =new User("harshi", this.passwordEncoder.encode("welcome"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		Role superAdminRole=new Role("ROLE_SUPER_ADMIN");

		shiva.addRole(userRole);

		ravi.addRole(userRole);
		ravi.addRole(adminRole);
		
		harshi.addRole(userRole);
		harshi.addRole(adminRole);
		harshi.addRole(superAdminRole);

		this.userRepository.save(shiva);
		this.userRepository.save(ravi);
		this.userRepository.save(harshi);

	}

}
