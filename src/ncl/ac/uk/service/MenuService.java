package ncl.ac.uk.service;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ncl.ac.uk.MenuFactory;

/**
 * MenuService class provides the user interface for different Music Library
 * operation. These operation are classified as per coursework specification.
 * This class accepts the user input and manipulates the control to
 * {@link MenuFactory}.
 */
public class MenuService {
	private MenuFactory menuObj = new MenuAction();
	private Map<Integer, MenuInterf> menuNames = new Hashtable<Integer, MenuInterf>();

	/**
	 * Intialize the constructor with the menu action objects. To eleminate multiple
	 * if else statement based on user input
	 * 
	 * @implNote Lambda expression used with functional interface
	 * @see MenuInterf
	 */
	public MenuService() {

		menuNames.put(1, () -> menuObj.getMenuAction1());
		menuNames.put(2, () -> menuObj.getMenuAction2());
		menuNames.put(3, () -> menuObj.getMenuAction3());
		menuNames.put(4, () -> menuObj.getMenuAction4());
		menuNames.put(5, () -> menuObj.getMenuAction5());
		menuNames.put(6, () -> menuObj.getMenuAction6());
		menuNames.put(7, () -> menuObj.getMenuAction7());
		menuNames.put(8, () -> menuObj.getMenuAction8());
		menuNames.put(9, () -> {
			System.out.println("Application terminated !!");
			System.exit(0);
		});
	}

	/**
	 * Method call for decision process for execution over user input and based on
	 * the input further methods calls for action are initiated.
	 * 
	 * @see MenuAction
	 */
	public void start() {

		System.out.println("----------Music Library Menu----------");
		System.out.println("1. Add Track");
		System.out.println("2. Get Tracks and Members");
		System.out.println("3. Add New Album");
		System.out.println("4. Add Tracks to Album");
		System.out.println("5. Get Run time, Size, Avg Rating of Album");
		System.out.println("6. Create Library and add tracks");
		System.out.println("7. List tracks with low rating from library");
		System.out.println("8. Backup the library");
		System.out.println("9. Close");
		System.out.print("Enter the option number: ");
		try {
			Scanner scnObj = new Scanner(System.in);
			int userInput = scnObj.nextInt();
			getMenuNumber(userInput);
			scnObj.close();

		} catch (InputMismatchException e) {
			System.out.println("Please enter the correct number of the menu " + e);
		} catch (NoSuchElementException e) {
			System.out.println("No string characters are valid " + e);
		}

	}

	/**
	 * This method takes one input for decision making Based on the decision calls
	 * the method using {@link FunctionalInterface}
	 * 
	 * @param no
	 */
	void getMenuNumber(int no) {

		if (menuNames.containsKey(no)) {
			menuNames.get(no).callMenu();
			System.out.println();
			start();

		}
	}

}

@FunctionalInterface
interface MenuInterf {
	/**
	 * Service provider for Lambda expression at {@link MenuService}
	 * 
	 * @see Java 1.8 Functional Interface
	 */
	void callMenu();
}
