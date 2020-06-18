package ncl.ac.uk;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ncl.ac.uk.service.LibraryService;
import ncl.ac.uk.service.MenuService;
import ncl.ac.uk.service.TrackService;

/**
 * This class is responisble for creation of new Library object creation. And
 * adding tracks/album to the library. The member variables are initalized at
 * LibraryService
 * 
 * @see LibraryService for variable initialization
 * @see addTracksToLib, listTracks services are provided in this class
 */
public class Library {

	List<TrackService> libTracks = new LinkedList<TrackService>();
	Map<String, List<TrackService>> libMp = new HashMap<String, List<TrackService>>();

	/**
	 * @return the initialized Library names and the tracks as Map<String>
	 *         List<TrackService>
	 */
	public Map<String, List<TrackService>> getLibMp() {
		return libMp;
	}

	/**
	 * @return the initialized tracks that are available in the library as
	 *         List<TrackService>
	 */
	public List<TrackService> getLibTracks() {
		return libTracks;
	}

	/**
	 * @param libTracks initialize the library with the list of tracks as
	 *                  List<TrackService>
	 */
	public void setLibTracks(List<TrackService> libTracks) {
		this.libTracks = libTracks;
	}

	/**
	 * This method creates new library
	 * 
	 * @param libName as String from the {@link MenuService}
	 */
	public void addLib(String libName) {
		LibraryService serObj = new LibraryService(libName);
		libMp.put(serObj.getLibName(), null);
		System.out.println("Library created successfully..");
		System.out.println("");

	}

	/**
	 * This method adds list of tracks to the library
	 * 
	 * @param obj as Object which gets the Track class object form
	 *            {@link MenuService}
	 */
	public void addTracksToLib(Track obj, String libName) {

		for (TrackService data : obj.getTrackLst()) {
			libTracks.add(data);
		}
		libMp.put(libName, libTracks);
		System.out.println("Added tracks to library -" + libName + "..");
	}

	/**
	 * This method unpacks the list of tracks that are below the specified rating
	 * from {@link MenuService}. The date and time representation are formated using
	 * {@link SimpleDateFormat} with hh:mm
	 * 
	 * @param rating  as double
	 * @param libName as String
	 * 
	 */
	public void listTracks(double rating, String libName) {
		System.out.println("Track Name \t Length \t Rating \t Size \t Play Count");
		System.out.println("----------");

		if (libMp.containsKey(libName)) {
			for (TrackService data : libTracks) {
				if (data.getTrkRating() <= rating) {
					System.out.println(data.getTrkTitle() + "\t"
							+ new SimpleDateFormat("hh:mm").format(data.getTrkLength()) + "\t\t" + data.getTrkRating()
							+ "\t\t" + data.getTrkSize() + " MB \t" + data.getTrkPlaycount());
				}
			}
		}

	}

}
