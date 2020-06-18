package ncl.ac.uk;

import ncl.ac.uk.service.MenuService;

/**
 * Project Name - Music Library
 * 
 * @author AshokKumar
 * @version 1.0
 * 
 */
public class Main {
	/**
	 * Creates a new object for {@link MenuService} and calls the start method.
	 * 
	 * @see Test cases are implemented in a seperate package {@link ncl.ac.uk.test}
	 */
	public static void main(String[] args) {
		MenuService servObj = new MenuService();
		servObj.start();
	}
}
