package com.sndi.security;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 

/**
 * @author BAH Glaho Jean Herv�
 * Novembre 2018
 * Company: SNDI
 *
 */
public class CustomPasswordEncoder implements PasswordEncoder{
	
	 @Override
	    public String encode(CharSequence rawPassword) {
	 
	        String hashed = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
	 
	        return hashed;
	    }
	 
	    @Override
	    public boolean matches(CharSequence rawPassword, String encodedPassword) {
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    	
	    	
	      //  return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	    	return passwordEncoder.matches(rawPassword.toString(), encodedPassword);
	    }
}
