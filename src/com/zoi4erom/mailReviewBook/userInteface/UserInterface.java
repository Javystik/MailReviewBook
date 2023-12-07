package com.zoi4erom.mailReviewBook.userInteface;

import com.zoi4erom.mailReviewBook.dataLayer.ReadFile;
import com.zoi4erom.mailReviewBook.serviceLayer.ReviewManager;
import com.zoi4erom.mailReviewBook.serviceLayer.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * The UserInterface class provides a user interface for the Mail Review Book application.
 */
public class UserInterface {

	private static Scanner scanner = new Scanner(System.in);
	private static UserManager userManager = new UserManager();
	private static ReadFile readFile = new ReadFile();
	private static int activeUserId = 0;
	private static String activeUserName = "";
	private boolean isExit = false;

	/**
	 * Runs the main menu of the application.
	 */
	public void runMenu() {
		while (!isExit) {
			entryMenu();
		}
	}

	/**
	 * Displays the main menu options for review management.
	 */
	public void mainMenu() {
		System.out.println("Головне меню відгуків Пошт");
		System.out.println("1: Обрати пошту для написання відгука");
		System.out.println("2: Всі відгуки");
		System.out.println("0: Вихід");
		System.out.print("Мій вибір: ");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				addReview();
				break;
			case 2:
				readFile.readingFileUsingNumber(1);
				mainMenu();
				break;
			case 0:
				isExit = true;
				break;
		}
	}

	/**
	 * Allows the user to add a new review.
	 */
	public void addReview() {
		scanner.nextLine();

		System.out.print("Напишіть пошту на яку адресований відгук: ");
		String mail = scanner.nextLine();
		System.out.print("Введіть кількість зірок(1-5): ");
		int number = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Введіть опис відгука: ");
		String description = scanner.nextLine();

		LocalDateTime localDateTime = LocalDateTime.now();

		ReviewManager reviewManager = new ReviewManager();
		reviewManager.addReview(activeUserName, number, description, localDateTime, activeUserId, mail);

		mainMenu();
	}

	/**
	 * Displays the entry menu for user authorization and registration.
	 */
	public void entryMenu() {
		System.out.println("Меню авторизації та реєстрації!");
		System.out.println("1: Авторизація");
		System.out.println("2: Реєстрація");
		System.out.println("0: Вихід");
		System.out.print("Ваш вибір: ");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				authorizedUser();
				break;
			case 2:
				registerUser();
				break;

			case 0:
				isExit = true;
				break;
			default:
				System.out.println("Не вірний ввід! Попробуйте ще раз!");
				break;
		}
	}

	/**
	 * Allows the user to register a new account.
	 */
	public void registerUser() {
		System.out.println("Реєстраційне меню");
		System.out.print("Введіть логін: ");
		String login = scanner.next();
		System.out.print("Введіть пароль: ");
		String password = scanner.next();

		activeUserId = userManager.createUser(login, password);

		if (activeUserId == 0) {
			System.out.println("Помилка! Такий логін вже існує!");
		}

		System.out.println("Аккаунт успішно створений!");
	}

	/**
	 * Allows the user to log in.
	 */
	public void authorizedUser() {
		System.out.println("Авторизаційне меню");
		System.out.print("Введіть логін: ");
		String login = scanner.next();
		System.out.print("Введіть пароль: ");
		String password = scanner.next();

		String[] userInfo = userManager.findUser(login, password);

		if (userInfo != null) {
			activeUserName = userInfo[0];
			activeUserId = Integer.parseInt(userInfo[1]);
			System.out.println("Авторизація успішна. Ім'я активного користувача: " + activeUserName +
			    ", ID активного користувача: " + activeUserId);
			mainMenu();
		} else {
			System.out.println("Користувач не знайдений.");
		}
	}
}