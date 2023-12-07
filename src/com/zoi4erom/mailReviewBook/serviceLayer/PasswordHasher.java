package com.zoi4erom.mailReviewBook.serviceLayer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The PasswordHasher class provides methods for hashing passwords and checking them against stored hashes.
 */
public class PasswordHasher {

	/**
	 * Hashes the provided password using SHA-256.
	 *
	 * @param password The password to be hashed.
	 * @return A hexadecimal string representing the hashed password.
	 */
	public static String hashPassword(String password) {
		try {
			// Get an instance of SHA-256 MessageDigest.
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(password.getBytes());

			// Convert the byte array to a hexadecimal string.
			StringBuilder sb = new StringBuilder();
			for (byte b : hashedBytes) {
				sb.append(String.format("%02x", b));
			}

			// Return the hashed password as a string.
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// Print the exception stack trace and return null if NoSuchAlgorithmException occurs.
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Checks if the input password matches the stored hash.
	 *
	 * @param inputPassword The password to be checked.
	 * @param storedHash    The stored hash to compare against.
	 * @return True if the input password matches the stored hash, false otherwise.
	 */
	public static boolean checkPassword(String inputPassword, String storedHash) {
		// Hash the input password for comparison.
		String hashedInput = hashPassword(inputPassword);

		// Return true if the hashed input password matches the stored hash.
		return hashedInput != null && hashedInput.equals(storedHash);
	}
}