package ncl.ac.uk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ncl.ac.uk.service.AlbumService;

/**
 * This class is responsible for creation of Album and adding tracks to the
 * created album. The memeber varaible initilization are carried out by
 * AlbumService.
 * 
 * @see AlbumService Which act as service provider for variable intialization.
 * @implNote All member variables of this class are private therefore getters
 *           and setters are used to encapsulation
 */
public class Album {

	private List<AlbumService> albmLst = new ArrayList<AlbumService>();
	Map<String, List<String>> albmTrkLst = new LinkedHashMap<String, List<String>>();

	/**
	 * @return the initialized list of Album names as List<AlbumService>
	 */
	public List<AlbumService> getAlbmLst() {
		return albmLst;
	}

	/**
	 * @param albmLst initialize the album name as List<AlbumService>
	 */
	public void setAlbmLst(List<AlbumService> albmLst) {
		this.albmLst = albmLst;
	}

	/**
	 * @return the initialized albums with its tracks as Map<String, List<String>>
	 */
	public Map<String, List<String>> getAlbmTrkLst() {
		return albmTrkLst;
	}

	/**
	 * @param albmTrkLst initialize the list of tracks to the album as Map<String,
	 *                   List<String>>
	 */
	public void setAlbmTrkLst(Map<String, List<String>> albmTrkLst) {
		this.albmTrkLst = albmTrkLst;
	}

	/**
	 * This method is responsible for creating a new album
	 * 
	 * @param albName   for album name
	 * @param albType   for album type
	 * @param albArtist for album artist
	 * @implNote The objects are initilized by the service provider
	 *           {@code AlbumService}
	 */
	public void addAlbm(String albName, String albType, String albArtist) {

		AlbumService albsrvcObj = new AlbumService(albName, albType, albArtist);
		albmLst.add(albsrvcObj);

	}

	/**
	 * This method is responsible for adding tracks to the album. The track and
	 * album names are provided as arguments and stored in Map<String, List<String>>
	 * 
	 * @param albmName for name of the album
	 * @param trkNames for track name
	 * 
	 * @throws IllegalArgumentException
	 */
	public void addTracksToAlbum(String albmName, List<String> trkNames) {

		try {
			Map<String, List<String>> mp = new HashMap<String, List<String>>();
			mp.put(albmName, trkNames);
			setAlbmTrkLst(mp);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
