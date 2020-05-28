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

public class AddTrack {
	String[] value;
	private List<TrackService> trackLst = new ArrayList<TrackService>();
	private Map<String, List<String>> bandLst = new HashMap<String, List<String>>();

	public Map<String, List<String>> getBandLst() {
		return bandLst;
	}

	public void setBandLst(Map<String, List<String>> bandLst) {
		this.bandLst = bandLst;
	}

	public List<TrackService> getTrackLst() {
		return trackLst;
	}

	public void setTrackLst(List<TrackService> trackLst) {
		this.trackLst = trackLst;
	}

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
			System.out.println("Tracks and members are added successfully..");

		} catch (FileNotFoundException e) {
			System.out.println("File reading error: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Date Time parse exception occured" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
