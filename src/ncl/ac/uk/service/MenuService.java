package ncl.ac.uk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import ncl.ac.uk.AddAlbum;
import ncl.ac.uk.AddTrack;

public class MenuService {
	private AddTrack trkObj = new AddTrack();
	private AddAlbum albmObj = new AddAlbum();

	public void start() {

		System.out.println("----------Music Library Menu----------");
		System.out.println("1. Add Track");
		System.out.println("2. Get Tracks and members");
		System.out.println("3. Add New Album");
		System.out.println("4. Add Tracks to Album");
		System.out.println("5. Get Run time, Size, Avg Rating of Album");
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
			scnObj.close();

		} catch (InputMismatchException e) {
			System.out.println("Please enter the correct number of the menu " + e);
		}

	}

	private void getMenuAction2() {
		System.out.println("---Track Name------Members---");
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

	private void getMenuAction4() {
		List<String> trkNames = new ArrayList<String>();
		trkNames.add("Alone Again");
		trkNames.add("Blinding Lights");

		String albmName = "After Hours";

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

	private void getMenuAction5() {
		String albmName = "After Hours";
		SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm");
		long runTime = 0;
		int recCount = 0;
		double trkSize = 0.0, trkRating = 0.0;
		try {

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
				System.out.println("Album file size: \t" + trkSize+" MB");
				System.out.println("Average rating : \t" + trkRating / recCount);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
