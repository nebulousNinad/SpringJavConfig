package com.journaldev.spring.security;

import java.util.Base64;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence arg0) {
		
		
		byte [] ba = arg0.toString().getBytes();
		
		String encoded = Base64.getEncoder().encodeToString(ba);
		
		return encoded;
	}

	@Override
	public boolean matches(CharSequence raw, String encoded) {
	
		byte [] decoded = Base64.getDecoder().decode(encoded);
	
		
		return false;
	}

}
