package com.zoi4erom.mailReviewBook.serviceLayer;

/**
 * The FilePathProvider class provides methods to obtain file paths based on specified numbers.
 */
public class FilePathProvider {

	/**
	 * Gets the file path based on the provided number.
	 *
	 * @param number The identifier used to determine the file path.
	 * @return A string representing the file path corresponding to the given number.
	 */
	public static String getFilePath(int number) {
		// Base directory for file paths.
		String baseDir = "src/com/zoi4erom/mailReviewBook/dataLayer/";
		String filePath = "";

		// Determine the file path based on the provided number.
		if (number == 1) {
			filePath = baseDir + "review.txt";
		} else if (number == 2) {
			filePath = baseDir + "users.txt";
		}

		// Return the generated file path.
		return filePath;
	}
}