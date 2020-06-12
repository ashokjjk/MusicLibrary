package ncl.ac.uk.service;

import java.util.List;

/**
 * Simple POJO implementation for Track Class, which acts as service provider
 * for members varaibles of the track. This class is responisble for variable
 * initialization and returns the variable value for Track class objects.
 * 
 * @implNote Uses default and parametrized constructor and getter, setters for
 *           private variables and offers encapuslation.
 */

public class BandMembersService {

	private String trkTitle;
	private List<String> trkBandMem;

	public BandMembersService() {

	}

	public BandMembersService(String trkTitle, List<String> trkBandMem) {
		super();
		this.trkTitle = trkTitle;
		this.trkBandMem = trkBandMem;
	}

	/**
	 * @return the initialized Track title as String
	 */
	public String getTrkTitle() {
		return trkTitle;
	}

	/**
	 * @param trkTitle initialize the track title as String
	 */
	public void setTrkTitle(String trkTitle) {
		this.trkTitle = trkTitle;
	}

	/**
	 * @return the initialized Track members as List<String>
	 */
	public List<String> getTrkBandMem() {
		return trkBandMem;
	}

	/**
	 * @param trkBandMem initialize the track members for the current track as
	 *                   List<String>
	 */
	public void setTrkBandMem(List<String> trkBandMem) {
		this.trkBandMem = trkBandMem;
	}

}
