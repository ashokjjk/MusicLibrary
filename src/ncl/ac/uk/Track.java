package ncl.ac.uk;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ncl.ac.uk.service.BandMembersService;
import ncl.ac.uk.service.TrackService;

/**
 * It is the driver class for Media Library. Which accepts the List of tracks as
 * input and stores it in the List and Members in Map as Key value pair. All the
 * member variables of this class are private therefore getter & setters are used
 * to initialize the member variables.
 * 
 */
public class Track {
	String[] value;
	private List<TrackService> trackLst;
	private Map<String, List<String>> bandLst;
	
	/**
	 * Intializes the data members of this class
	 */
	public Track() {
		trackLst = new ArrayList<TrackService>();
		bandLst = new HashMap<String, List<String>>();
	}
	
	/**
	 * @return the initialized list of bands as Map<String, List<String>>
	 */
	public Map<String, List<String>> getBandLst() {
		return bandLst;
	}

	/**
	 * @param bandLst initialize the Map of band members as Map<String,
	 *                List<String>>
	 */
	public void setBandLst(Map<String, List<String>> bandLst) {
		this.bandLst = bandLst;
	}

	/**
	 * @return the initialized list of tracks as List<TrackService>
	 */
	public List<TrackService> getTrackLst() {
		return trackLst;
	}

	/**
	 * @param trackLst initialize the list of tracks as List<TrackService>
	 */
	public void setTrackLst(List<TrackService> trackLst) {
		this.trackLst = trackLst;
	}

	/**
	 * This method accepts the track metadata from the resource file that is
	 * specified in the Resources folder under the file name Tracks.txt. The
	 * metadata is seperated with comma seperated value therefore each line is
	 * parsed to get the appropirate value. The track date and Track length are
	 * stored as Date datatype. Once the metadata is categorized it is stored in
	 * List<TrackService> object
	 * 
	 * @see Resources/Tracks.txt for adding new tracks.
	 * @see TrackService acts as a service provider for variable intialization.
	 * @see Date and time are formatted using {@link SimpleDateFormat} with
	 *      dd/MM/yyy hh:mm
	 * @throws FileNotFoundException when the input file is not found in resource.
	 * @throws ParseException        when the track date is not in correct format.
	 * 
	 */
	public void addTrack() {
		try {
			FileReader rdData = new FileReader("Resources/Tracks.txt");
			Scanner scData = new Scanner(rdData);

			SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat lnthFormat = new SimpleDateFormat("hh:mm");

			while (scData.hasNext()) {
				value = scData.nextLine().split(",");
				TrackService newTrak = new TrackService();
				newTrak.setTrkTitle(value[0]);
				newTrak.setTrkArtist(value[1]);
				newTrak.setTrkGstArtst(value[2]);
				newTrak.setTrkDate(dtFormat.parse(value[3]));
				newTrak.setTrkLength(lnthFormat.parse(value[4]));
				newTrak.setTrkRating(Double.parseDouble(value[5]));
				newTrak.setTrkLocation(value[6]);
				newTrak.setTrkSize(Double.parseDouble(value[7]));
				newTrak.setTrkPlaycount(Integer.parseInt(value[8]));
				trackLst.add(newTrak);
			}

			scData.close();
			System.out.println("Tracks created successfully..");
			addMembers();

		} catch (FileNotFoundException e) {
			System.out.println("File reading error: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Date Time parse exception occured" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * This method accepts no parameter and reads the track member details from the
	 * Resource folder, TrackMembers.txt. All the values are reperesented as comma
	 * seperated value. The values are stored as Map<String List<String>>. Where
	 * each track tile will have a collection of track members.
	 * 
	 * @see Resources/TrackMembers.txt directive for adding new members to track.
	 * @throws FileNotFoundException when resource file is not found.
	 * 
	 */
	public void addMembers() throws FileNotFoundException {
		// O(n^2)
		for (TrackService data : trackLst) {
			List<String> trkMembrsLst = new LinkedList<String>();

			FileReader rdMemData = new FileReader("Resources/TrackMembers.txt");
			Scanner scTrkData = new Scanner(rdMemData);

			while (scTrkData.hasNextLine()) {
				String[] trkMem = scTrkData.nextLine().split(",");
				if (data.getTrkTitle().equals(trkMem[0])) {
					trkMembrsLst.add(trkMem[1]);
				}
			}
			scTrkData.close();
			BandMembersService bdObj = new BandMembersService(data.getTrkTitle(), trkMembrsLst);
			bandLst.put(bdObj.getTrkTitle(), bdObj.getTrkBandMem());
		}
		System.out.println("Members are added to the corresponding tracks..");

	}

}
