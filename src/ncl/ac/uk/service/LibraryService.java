package ncl.ac.uk.service;

/**
 * Simple POJO implementation for Library class @see Library. This class is
 * responsible for variable intialization and returns value for Library object
 * 
 * @implSpec Return the overrided method of toString() for object call.
 * @implNote Uses parametrized constructor and getter, setters for private
 *           variables and offers encapuslation.
 */
public class LibraryService {

	private String libName;

	public LibraryService(String libName) {
		super();
		this.libName = libName;
	}

	/**
	 * @return the initialized Library name as String
	 */
	public String getLibName() {
		return libName;
	}

	/**
	 * @param libName as String and initialize the Library name
	 */
	public void setLibName(String libName) {
		this.libName = libName;
	}

	/**
	 * @return the string of Library objects seperated by ','
	 */
	@Override
	public String toString() {
		return libName;
	}

}
