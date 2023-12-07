package com.zoi4erom.mailReviewBook.dataLayer;

import com.zoi4erom.mailReviewBook.serviceLayer.FilePathProvider;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The CreateFile class provides methods for adding new information to a file.
 */
public class CreateFile {

	/**
	 * Adds new information to a file for a given number.
	 *
	 * @param number The identifier used to generate the file path.
	 * @param write  The information to be written to the file.
	 * @return True if the information is successfully added, false otherwise.
	 */
	public boolean addNewInformationInFileForNumber(int number, String write) {
		// Get the file path based on the provided number.
		String filePath = FilePathProvider.getFilePath(number);

		try (
		    // Open a FileWriter and a BufferedWriter for efficient writing.
		    FileWriter fileWriter = new FileWriter(filePath, true);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
		) {
			// Create a File object to check the existing file length.
			File file = new File(filePath);

			// If the file is not empty, add a new line before writing the new information.
			if (file.length() > 0) {
				bufferedWriter.newLine();
			}

			// Write the information to the file.
			bufferedWriter.write(write);
			return true;

		} catch (IOException e) {
			// Print the exception stack trace and return false if an IOException occurs.
			e.printStackTrace();
			return false;
		}
	}
}