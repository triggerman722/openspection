package com.openspection.auth.service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import com.openspection.auth.model.User;
import com.openspection.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class LinkedinConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserService UserService;

    @Override
    public String execute(Connection<?> connection) {
System.out.println("conn: " + connection.getDisplayName());
	User existingUser = UserService.findByUsername(connection.getDisplayName().toString());
	if (existingUser == null) {
	        System.out.println("signup === ");
        	final User user = new User();
	        user.setUsername(connection.getDisplayName());
        	user.setPassword(randomAlphabetic(8));
	        UserService.save(user);
		return user.getUsername();
        }
System.out.println("null");
        return existingUser.getUsername();
    }

}
