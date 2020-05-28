package ncl.ac.uk;

import ncl.ac.uk.service.MenuService;

public class Main {

	public static void main(String[] args) {

		MenuService servObj = new MenuService();
		servObj.start();

	}

}
