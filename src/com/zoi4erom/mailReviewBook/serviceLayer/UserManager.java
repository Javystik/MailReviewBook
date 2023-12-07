package com.zoi4erom.mailReviewBook.serviceLayer;

import com.zoi4erom.mailReviewBook.dataLayer.CreateFile;
import com.zoi4erom.mailReviewBook.dataLayer.ReadFile;

import java.util.Random;

/**
 * The UserManager class provides methods for managing user-related operations.
 */
public class UserManager {

	/**
	 * Creates a new user with the specified login and password.
	 *
	 * @param login    The login or username for the new user.
	 * @param password The password for the new user.
	 * @return The unique identifier (ID) of the newly created user, or 0 if the login already exists or hashing fails.
	 */
	public int createUser(String login, String password) {
		// Check if the login already exists.
		if (isLoginExists(login)) {
			return 0;
		}

		// Hash the password.
		String hashedPassword = PasswordHasher.hashPassword(password);
		if (hashedPassword == null) {
			return 0;
		}

		// Create a new User instance with the hashed password and a generated ID.
		User user = new User(login, hashedPassword, generateId());

		// Use the CreateFile class to add user information to a file.
		CreateFile createFile = new CreateFile();
		createFile.addNewInformationInFileForNumber(2, user.toString());

		// Return the unique identifier of the newly created user.
		return user.getId();
	}

	/**
	 * Checks if a login already exists in the user data file.
	 *
	 * @param login The login to check for existence.
	 * @return True if the login already exists, false otherwise.
	 */
	private boolean isLoginExists(String login) {
		ReadFile readFile = new ReadFile();
		String[] users = readFile.readingFileUsingNumber(2);

		for (String user : users) {
			String[] userInfo = user.split(":");

			if (userInfo.length >= 3) {
				String existingLogin = userInfo[0];

				// Return true if the login already exists.
				if (login.equals(existingLogin)) {
					return true;
				}
			}
		}
		// Return false if the login does not exist.
		return false;
	}

	/**
	 * Finds a user based on the provided login and password.
	 *
	 * @param login    The login or username of the user.
	 * @param password The password of the user.
	 * @return An array containing the username and user ID if the user is found, or null otherwise.
	 */
	public String[] findUser(String login, String password) {
		ReadFile readFile = new ReadFile();
		String[] users = readFile.readingFileUsingNumber(2);

		for (String user : users) {
			String[] userInfo = user.split(":");

			if (userInfo.length >= 3) {
				String username = userInfo[0];
				String userPassword = userInfo[1];
				String userId = userInfo[2];

				// Return user information if the login and password match.
				if (login.equals(username) && PasswordHasher.checkPassword(password, userPassword)) {
					return new String[]{username, userId};
				}
			}
		}
		// Return null if the user is not found.
		return null;
	}

	/**
	 * Generates a random user ID.
	 *
	 * @return A randomly generated user ID.
	 */
	public int generateId() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		// Generate a 9-digit random number.
		for (int i = 0; i < 9; i++) {
			stringBuilder.append(random.nextInt(9));
		}
		return Integer.parseInt(stringBuilder.toString());
	}
}