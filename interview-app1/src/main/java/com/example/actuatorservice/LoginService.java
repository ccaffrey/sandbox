package com.example.actuatorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	final String PLASTIQ_AUTHORIZED_USERNAME = "plastiq";
	final String PLASTIQ_AUTHORIZED_PASSWORD = "bigsecret";
	
	// Use an executor service to perform any login work in background thread(s)
	final ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	/**
	 * Login the user based on the supplied credentials
	 * 
	 * @return boolean result of login attempt
	 */
	public synchronized boolean login(final LoginCredentials credentials) throws Exception {
		
		final Future<Boolean> loginResponseFuture = executorService.submit(() -> {
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
	public synchronized Boolean authenticate(final LoginCredentials credentials) {
		return credentials.getUsername().equals(PLASTIQ_AUTHORIZED_USERNAME) && credentials.getPassword().equals(PLASTIQ_AUTHORIZED_PASSWORD);
	}	

}
