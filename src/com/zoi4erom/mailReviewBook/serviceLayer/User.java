package com.zoi4erom.mailReviewBook.serviceLayer;

/**
 * The User class represents a user with associated properties.
 */
public class User {

	private String login;
	private String password;
	private int id;

	/**
	 * Constructs a new User instance with the specified properties.
	 *
	 * @param login    The login or username of the user.
	 * @param password The password associated with the user.
	 * @param id       The unique identifier of the user.
	 */
	public User(String login, String password, int id) {
		this.login = login;
		this.password = password;
		this.id = id;
	}

	/**
	 * Gets the login or username of the user.
	 *
	 * @return The login or username.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login or username of the user.
	 *
	 * @param login The login or username to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password associated with the user.
	 *
	 * @return The password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password associated with the user.
	 *
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the unique identifier of the user.
	 *
	 * @return The user's unique identifier.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the user.
	 *
	 * @param id The user's unique identifier to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// Return a string representation of the user in the format "login:password:id".
		return login + ":" + password + ":" + id;
	}
}