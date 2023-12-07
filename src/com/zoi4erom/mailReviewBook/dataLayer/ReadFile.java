package com.zoi4erom.mailReviewBook.dataLayer;

import com.zoi4erom.mailReviewBook.serviceLayer.FilePathProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The ReadFile class provides methods for reading information from a file.
 */
public class ReadFile {

	/**
	 * Reads the content of a file based on the provided number.
	 *
	 * @param number The identifier used to generate the file path.
	 * @return An array of strings representing the lines read from the file.
	 */
	public String[] readingFileUsingNumber(int number) {
		// Get the file path based on the provided number.
		String filePath = FilePathProvider.getFilePath(number);

		try {
			// Open a FileReader and a BufferedReader for efficient reading.
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Variables to store each line and the complete result.
			String line;
			StringBuilder result = new StringBuilder();

			// Read each line from the file.
			while ((line = bufferedReader.readLine()) != null) {
				// Optionally, print each line if the number is 1.
				if (number == 1) {
					System.out.println(line);
				}

				// Append the line to the result with a newline character.
				result.append(line).append("\n");
			}

			// Close the readers.
			fileReader.close();
			bufferedReader.close();

			// Split the result into an array of strings based on newline characters.
			return result.toString().split("\n");

		} catch (IOException e) {
			// Print the exception stack trace if an IOException occurs.
			e.printStackTrace();
		}

		// Return an empty array if an exception occurs.
		return new String[0];
	}
}