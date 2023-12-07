package com.zoi4erom.mailReviewBook.main;

import com.zoi4erom.mailReviewBook.userInteface.UserInterface;

/**
 * The Main class serves as the entry point for the Mail Review Book application.
 */
public class Main {

	/**
	 * The main method initializes the UserInterface and starts the application.
	 *
	 * @param args Command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		// Create an instance of the UserInterface.
		UserInterface userInterface = new UserInterface();

		// Run the main menu of the application.
		userInterface.runMenu();
	}
}