package me.yurinero.RandomExploration.logic;

import java.security.SecureRandom;
/* This is an example usage of Random numbers, using them as a base for a password generator.
* The below implementation is quite simple, and we could expand it further, such as defining the characters differently.
* For example, we could put them in a Map, and let the user toggle which characters they want/don't want within their password.
* Further, we could add more functionality by adding user defined flags to prevent duplicate characters if they so desire.
* While here in the Source we can set a size, It is not implemented in the GUI.
 */


public class PasswordGen {

	SecureRandom passwordRandom = new SecureRandom();
	String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lowercase = "abcdefghijklmnopqrstuvwxyz";
	String digits = "0123456789";
	String symbols = "!@#$%^&*()";
	String allChars = uppercase + lowercase + digits + symbols;

	public PasswordGen() {
		this.passwordRandom = new SecureRandom();
	}

	public String generatePassword(int length) {
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int randomIndex = passwordRandom.nextInt(allChars.length());
			password.append(allChars.charAt(randomIndex));
		}
		return password.toString();
	}
}
