package com.zoi4erom.mailReviewBook.serviceLayer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Review class represents a user review with associated properties.
 */
public class Review {

	private String user;
	private char[] rating;
	private String description;
	private LocalDateTime publicationDate;
	private int id;
	private String mail;

	// Date and time formatter for consistent formatting.
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy HH:mm");

	/**
	 * Constructs a new Review instance with the specified properties.
	 *
	 * @param user            The user associated with the review.
	 * @param rating          The rating given as an array of characters.
	 * @param description     The description or content of the review.
	 * @param publicationDate The date and time when the review was published.
	 * @param id              The unique identifier of the review.
	 * @param mail            The email address associated with the review.
	 */
	public Review(String user, char[] rating, String description, LocalDateTime publicationDate, int id, String mail) {
		this.user = user;
		this.rating = rating;
		this.description = description;
		this.publicationDate = publicationDate;
		this.id = id;
		this.mail = mail;
	}

	// Getter and setter methods for each property...

	@Override
	public String toString() {
		// Format the publication date using the defined formatter.
		String formattedDateTime = publicationDate.format(formatter);

		// Create a string representation of the review.
		return "User: " + user + " " + new String(rating) + "\n"
		    + "Опис: " + description + "\n"
		    + "Дата публікації: " + formattedDateTime + ", " + "Пошта: " + mail + "\n";
	}
}