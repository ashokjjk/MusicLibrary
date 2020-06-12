package ncl.ac.uk.service;

public class AlbumService {
	/**
	 * Simple POJO implementation for the Album class. This class works as a service
	 * provider for all the varaible to be initialized in the album class. This
	 * class returns toString() for the object when object is called. This class has
	 * parametrized constructot with getters and setters since all the member
	 * variable has private access modifier
	 */
	private String albmName;
	private String albmType;
	private String albmArtist;

	public AlbumService(String albmName, String albmType, String albmArtist) {
		super();
		this.albmName = albmName;
		this.albmType = albmType;
		this.albmArtist = albmArtist;
	}

	/**
	 * @return the initialized albumName
	 */
	public String getAlbmName() {
		return albmName;
	}

	/**
	 * @param albumName initialize the name of the album
	 */
	public void setAlbmName(String albmName) {
		this.albmName = albmName;
	}

	/**
	 * @return the initialized albumType
	 */
	public String getAlbmType() {
		return albmType;
	}

	/**
	 * @param albumType initialize the type of the album
	 */
	public void setAlbmType(String albmType) {
		this.albmType = albmType;
	}

	/**
	 * @return the initialized albumArtist
	 */
	public String getAlbmArtist() {
		return albmArtist;
	}

	/**
	 * @param albumArtist initialize the name of the Artist for the album
	 */
	public void setAlbmArtist(String albmArtist) {
		this.albmArtist = albmArtist;
	}

	/**
	 * @return the string of Album objects seperated by ','
	 */
	@Override
	public String toString() {
		return albmName + "," + albmType + "," + albmArtist;
	}

}
