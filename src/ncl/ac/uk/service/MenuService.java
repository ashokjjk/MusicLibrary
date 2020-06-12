package ncl.ac.uk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.Scanner;

import ncl.ac.uk.Album;
import ncl.ac.uk.BinPackaging;
import ncl.ac.uk.Library;
import ncl.ac.uk.Track;

/**
 * MenuService class provides the user interface for various Music Library
 * operation. These operation are classified as per coursework specification.
 * This class accepts the user input and manipulates the control to appropirate
 * methods.
 */
public class MenuService {
	private Track trkObj = new Track();
	private Album albmObj = new Album();
	private Library libObj = new Library();

	/**
	 * Simple method call acts as decision process for execution over user input And
	 * based on the input further methods calls are initiated.
	 */
	public void start() {

		System.out.println("----------Music Library Menu----------");
		System.out.println("1. Add Track");
		System.out.println("2. Get Tracks and Members");
		System.out.println("3. Add New Album");
		System.out.println("4. Add Tracks to Album");
		System.out.println("5. Get Run time, Size, Avg Rating of Album");
		System.out.println("6. Create Library and add tracks");
		System.out.println("7. List tracks with low rating from library");
		System.out.println("8. Backup the library");
		System.out.println("9. Close");
		System.out.print("Enter the option number: ");
		try {
			Scanner scnObj = new Scanner(System.in);
			int userInput = scnObj.nextInt();

			if (userInput == 1) {
				trkObj.addTrack();
				System.out.println("");
				start();
			}
			if (userInput == 2) {
				getMenuAction2();
				System.out.println("");
				start();
			}
			if (userInput == 3) {
				getMenuAction3();
				System.out.println("");
				start();
			}
			if (userInput == 4) {
				getMenuAction4();
				System.out.println("");
				start();
			}
			if (userInput == 5) {
				getMenuAction5();
				System.out.println("");
				start();
			}
			if (userInput == 6) {
				getMenuAction6();
				System.out.println("");
				start();
			}
			if (userInput == 7) {
				getMenuAction7();
				System.out.println("");
				start();
			}
			if (userInput == 8) {
				getMenuAction8();
				System.out.println("");
				start();
			}
			if (userInput == 9) {
				System.out.println("Application terminated!!!");
				System.exit(0);
			}
			scnObj.close();

		} catch (InputMismatchException e) {
			System.out.println("Please enter the correct number of the menu " + e);
		} catch (NoSuchElementException e) {
			System.out.println("No string characters are valid " + e);
		}

	}

	/**
	 * This method accepts no parameter but retrives the list of tracks from the
	 * memory using object of the Track class and display in a formated string. Also
	 * it retrives the track members added of the track.
	 */
	private void getMenuAction2() {
		System.out.println("---Track Name------Members---");
		// O(n^2)
		for (Entry<String, List<String>> data : trkObj.getBandLst().entrySet()) {
			System.out.print(data.getKey());
			int count = 0;
			if (data.getValue().size() > 1) {
				for (String memData : data.getValue()) {
					if (count == 0) {
						System.out.println("\t" + memData);
						count++;
					} else {
						System.out.print("                ");
						System.out.println("" + memData);
					}
				}
			}
		}
		System.out.println("");
		System.out.println(
				"Track Title \t Artist Name \t Guest Artist \t Date \t Track Length \t Rating \t Location \t File Size \t Play count");
		for (TrackService data : trkObj.getTrackLst()) {
			String gstArtst = (data.getTrkGstArtst().equals("")) ? "\t" : data.getTrkGstArtst();
			System.out.println(data.getTrkTitle() + "\t" + data.getTrkArtist() + "\t" + gstArtst + "\t"
					+ new SimpleDateFormat("dd/MM/yyyy").format(data.getTrkDate()) + "\t"
					+ new SimpleDateFormat("hh:mm").format(data.getTrkLength()) + "\t" + data.getTrkRating() + "\t"
					+ data.getTrkLocation() + "\t\t" + data.getTrkSize() + "\t\t" + data.getTrkPlaycount());
		}

	}

	/**
	 * This method accepts no parameter but retrives the list of albums from the
	 * memory using object of the Album class.
	 */
	private void getMenuAction3() {
		String albmName = "After Hours";
		albmObj.addAlbm(albmName, "Rock", "The Weeknd");

		System.out.println("Album Name \t Type \t Artist");
		System.out.println("-----------------------------------");
		for (AlbumService data : albmObj.getAlbmLst()) {
			System.out.println(data.getAlbmName() + "\t" + data.getAlbmType() + "\t" + data.getAlbmArtist() + "\n");
		}
		System.out.println("Album created successfully..");

	}

	/**
	 * This method accepts no parameter. It creates a list of tracks that are to be
	 * added for the specific album. Before adding it checks whether the album
	 * specified is available or not. After successful insertion it retrives the
	 * list of available tracks from the memory of that particular album using
	 * object of the Album class.
	 */
	private void getMenuAction4() {
		List<String> trkNames = new ArrayList<String>();
		trkNames.add("Alone Again");
		trkNames.add("Blinding Lights");

		String albmName = "After Hours";
		// O(n^2)
		for (TrackService data : trkObj.getTrackLst()) {
			for (String usrTrkLst : trkNames) {
				if (data.getTrkTitle().equals(usrTrkLst)) {
					albmObj.addTracksToAlbum(albmName, trkNames);
				}
			}
		}
		System.out.println("Album Name ----- Track Name");
		for (Entry<String, List<String>> data : albmObj.getAlbmTrkLst().entrySet()) {
			System.out.print(data.getKey());
			int count = 0;
			if (data.getValue().size() > 1) {
				for (String trkLstData : data.getValue()) {
					if (count == 0) {
						System.out.println("\t" + trkLstData);
						count++;
					} else {
						System.out.println("\t\t" + trkLstData);
					}
				}
			}
		}
		System.out.println("");
		System.out.println("Added the above tracks to album");

	}

	/**
	 * This method accepts no parameter but retrives the total running time, total
	 * size and average rating of the tracks in the specified album from the memory
	 * using object of the album class.
	 */
	private void getMenuAction5() {
		String albmName = "After Hours";
		SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm");
		long runTime = 0;
		int recCount = 0;
		double trkSize = 0.0, trkRating = 0.0;
		try {
			// O(n^3) Time complexity will be higher
			for (Entry<String, List<String>> data : albmObj.getAlbmTrkLst().entrySet()) {
				if (data.getKey().equals(albmName)) {
					List<String> trkName = data.getValue();
					for (String lstData : trkName) {
						for (TrackService trkData : trkObj.getTrackLst()) {
							if (trkData.getTrkTitle().equals(lstData)) {
								trkSize += trkData.getTrkSize();
								trkRating += trkData.getTrkRating();
								runTime += trkData.getTrkLength().getTime();
								recCount++;
							}
						}
					}
				}
				Date sumTime = new Date(runTime);
				System.out.println("Album running time: \t" + dtFormat.format(sumTime));
				System.out.println("Album file size: \t" + trkSize + " MB");
				System.out.println("Average rating : \t" + trkRating / recCount);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * This method accepts no parameter but creates an new library and list the
	 * library name from the memory using object of the Library class.
	 */
	private void getMenuAction6() {
		String libName = new String("American Music");
		libObj.addLib(libName);
		System.out.println("--Library Name--");
		for (Entry<String, List<TrackService>> data : libObj.getLibMp().entrySet()) {
			System.out.println(data.getKey());
		}

		libObj.addTracksToLib(trkObj, libName);
	}

	/**
	 * This method accepts no parameter but retrives the list of tracks which is
	 * below specified rating data for the given library from the memory using
	 * object of the Library class.
	 */
	private void getMenuAction7() {
		double rating = 5.5;
		String libName = "American Music";
		libObj.listTracks(rating, libName);

	}

	/**
	 * This method accepts no parameter. It ask the user for the total space of the
	 * media to backup. It works on the basis of bin packaging with "First fit"
	 */
	private void getMenuAction8() {

		try {
			@SuppressWarnings("resource")
			Scanner getInput = new Scanner(System.in);
			System.out.println("Enter the bin capacity: ");
			String libName = "American Music";
			int size = getInput.nextInt();
			System.out.println("Bin size is " + size);
			BinPackInterface pkObj = new BinPackaging();
			System.out.println("Total bins required are: " + pkObj.pack(libObj, libName, size));

		}

		catch (NoSuchElementException e) {
			System.out.println("Exception");
		}
	}
}
