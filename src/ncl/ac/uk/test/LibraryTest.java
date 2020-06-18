package ncl.ac.uk.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import ncl.ac.uk.Track;
import ncl.ac.uk.service.MenuService;

public class LibraryTest {

	/**
	 * Test case to check the menu components are loaded properly
	 */

	@Test
	public void testMainmenu() {
		MenuService srcObj = new MenuService();
		int size = srcObj.getMenuNames().size();
		assertEquals(9, size);

	}

	/**
	 * Test case to check appropirate number of track from resource files loaded
	 */
	@Test
	public void testNoofTracks() {
		Track trkObj = new Track();
		trkObj.addTrack();
		assertEquals(4, trkObj.getTrackLst().size());
	}

	/**
	 * Test case to check appropirate number of track and members are mapped to
	 * appropirate tracks from resource files loaded
	 */
	@Test
	public void testTrackMem() throws FileNotFoundException {
		Track trkObj = new Track();
		trkObj.addTrack();
		trkObj.addMembers();
		assertEquals(4, trkObj.getBandLst().size());
	}
}
