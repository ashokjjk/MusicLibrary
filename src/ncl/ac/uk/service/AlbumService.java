package ncl.ac.uk.service;

public class AlbumService {

	private String albmName;
	private String albmType;
	private String albmArtist;

	public AlbumService(String albmName, String albmType, String albmArtist) {
		super();
		this.albmName = albmName;
		this.albmType = albmType;
		this.albmArtist = albmArtist;
	}

	public String getAlbmName() {
		return albmName;
	}

	public void setAlbmName(String albmName) {
		this.albmName = albmName;
	}

	public String getAlbmType() {
		return albmType;
	}

	public void setAlbmType(String albmType) {
		this.albmType = albmType;
	}

	public String getAlbmArtist() {
		return albmArtist;
	}

	public void setAlbmArtist(String albmArtist) {
		this.albmArtist = albmArtist;
	}

	@Override
	public String toString() {
		return albmName + "," + albmType + "," + albmArtist;
	}

}
