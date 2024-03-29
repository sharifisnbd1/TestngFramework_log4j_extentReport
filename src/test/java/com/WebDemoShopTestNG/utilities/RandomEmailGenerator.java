package com.WebDemoShopTestNG.utilities;

import java.util.Random;

public class RandomEmailGenerator {

	 public static String generateRandomEmail() {
	        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder email = new StringBuilder();
	        Random random = new Random();
	        
	        // Generate a random string for the local part of the email
	        for (int i = 0; i < 10; i++) {
	            int index = random.nextInt(allowedChars.length());
	            email.append(allowedChars.charAt(index));
	        }
	        
	        // Append a fixed domain
	        email.append("@yahoo.com"); // You can replace "example.com" with your desired domain
	        
	        return email.toString();
	    }	
	
}
