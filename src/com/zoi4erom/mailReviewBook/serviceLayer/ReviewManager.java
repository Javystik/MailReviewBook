package com.zoi4erom.mailReviewBook.serviceLayer;

import com.zoi4erom.mailReviewBook.dataLayer.CreateFile;

import java.time.LocalDateTime;

/**
 * The ReviewManager class provides methods for managing reviews, including adding new reviews.
 */
public class ReviewManager {

	/**
	 * Adds a new review with the specified details.
	 *
	 * @param user            The user associated with the review.
	 * @param number          The rating given as a number (converted to star characters).
	 * @param description     The description or content of the review.
	 * @param publicationDate The date and time when the review was published.
	 * @param id              The unique identifier of the review.
	 * @param mail            The email address associated with the review.
	 */
	public void addReview(String user, int number, String description, LocalDateTime publicationDate, int id, String mail) {
		// Create a new Review instance with the specified details.
		Review review = new Review(user, ratingStar(number), description, publicationDate, id, mail);

		// Use the CreateFile class to add the review information to a file.
		CreateFile createFile = new CreateFile();
		createFile.addNewInformationInFileForNumber(1, review.toString());
	}

	/**
	 * Converts a numeric rating to an array of star characters ('★' and '☆').
	 *
	 * @param number The numeric rating to be converted.
	 * @return An array of star characters representing the rating.
	 */
	public char[] ratingStar(int number) {
		// Ensure the rating is within the valid range (1 to 5).
		if (number > 5) {
			number = 5;
		}

		// Create an array to represent the star rating.
		char[] starRating = new char[5];

		// Populate the array with star ('★') and empty star ('☆') characters based on the rating.
		for (int i = 0; i < 5; i++) {
			if (i < number) {
				starRating[i] = '★';
			} else {
				starRating[i] = '☆';
			}
		}

		// Return the array representing the star rating.
		return starRating;
	}
}