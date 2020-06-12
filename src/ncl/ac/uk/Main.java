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
	 * Creates a new object for {@link MenuService} and calls the start method
	 */
	public static void main(String[] args) {
		MenuService servObj = new MenuService();
		servObj.start();
	}
}
