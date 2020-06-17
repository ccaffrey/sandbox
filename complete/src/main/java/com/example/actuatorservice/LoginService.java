package com.example.actuatorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	final String AUTHORIZED_USER = "plastiq";
	final String UTHORIZED_PASSWORD = "bigsecret";
	
	final ExecutorService executor = Executors.newFixedThreadPool(10);
	
	/**
	 * Login the user based on the supplied credentials
	 * 
	 * @return boolean result of login attempt
	 */
	public synchronized boolean login(final LoginCredentials credentials) throws Exception {
		
		final Future<Boolean> loginResponseFuture = executor.submit(() -> {
		    return this.authenticate(credentials);
		});
		
		final boolean loginResult = loginResponseFuture.get();
		
		return loginResult;
	}
	
	
	/**
	 * Authenticate username/password credentials
	 * 
	 * TODO: delegate this logic to an external identity provider
	 * 
	 * @return boolean result of authentication
	 */
	public synchronized Boolean authenticate(final  LoginCredentials credentials) {
		return credentials.getUsername().equals(AUTHORIZED_USER) && credentials.getPassword().equals(UTHORIZED_PASSWORD);
	}	

}
