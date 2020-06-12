package ncl.ac.uk.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple POJO implementation for Track Class, which acts as service provider.
 * This class responisble for variable initialization and returns the variable
 * value for Track class objects.
 * 
 * @implSpec Return the overrided method of toString() for object call.
 * @implNote Uses default and parametrized constructor and getter, setters for
 *           private variables and offers encapuslation.
 * @see{@code setTrkGstArtst()} if the user provides "" for guest artist,
 *            initialization is handles with null for better object handling.
 */
public class TrackService {

	private String trkTitle, trkArtist, trkLocation, trkGstArtst;
	private Date trkLength, trkDate;
	private double trkSize, trkRating;
	private int trkPlaycount;

	public TrackService() {

	}

	public TrackService(String trkTitle, String trkArtist, String trkGstArtst, Date trkDate, Date trkLength,
			double trkRating, String trkLocation, double trkSize, int trkPlaycount) {
		super();
		this.trkTitle = trkTitle;
		this.trkArtist = trkArtist;
		this.trkGstArtst = trkGstArtst;
		this.trkLocation = trkLocation;
		this.trkDate = trkDate;
		this.trkLength = trkLength;
		this.trkSize = trkSize;
		this.trkRating = trkRating;
		this.trkPlaycount = trkPlaycount;
	}

	/**
	 * @return the initialized Track Title as String
	 */
	public String getTrkTitle() {
		return trkTitle;
	}

	/**
	 * @param trkTitle initialize the track title for the current track as String
	 */
	public void setTrkTitle(String trkTitle) {
		this.trkTitle = trkTitle;
	}

	/**
	 * @return the initialized Track Artist as String
	 */
	public String getTrkArtist() {
		return trkArtist;
	}

	/**
	 * @param trkArtist initialize the track artist for the current track as String
	 */
	public void setTrkArtist(String trkArtist) {
		this.trkArtist = trkArtist;
	}

	/**
	 * @return the initialized Track physical Location as String
	 */
	public String getTrkLocation() {
		return trkLocation;
	}

	/**
	 * @param trkLocation initialize the physical location for the current track as
	 *                    String
	 */
	public void setTrkLocation(String trkLocation) {
		this.trkLocation = trkLocation;
	}

	/**
	 * @return the initialized track date as Date datatype
	 */
	public Date getTrkDate() {
		return trkDate;
	}

	/**
	 * @param trkDate initialize the date for the current track as Date datatype
	 */
	public void setTrkDate(Date trkDate) {
		this.trkDate = trkDate;
	}

	/**
	 * @return the initialized running length of the track as Date
	 */
	public Date getTrkLength() {
		return trkLength;
	}

	/**
	 * @param trkLength initialize the length for the current track as Date datatype
	 */
	public void setTrkLength(Date trkLength) {
		this.trkLength = trkLength;
	}

	/**
	 * @return the initialized total size of the track in MB as double
	 */
	public double getTrkSize() {
		return trkSize;
	}

	/**
	 * @param trkSize initialize the size for the current track as double
	 */
	public void setTrkSize(double trkSize) {
		this.trkSize = trkSize;
	}

	/**
	 * @return the initialized rating of the track as double
	 */
	public double getTrkRating() {
		return trkRating;
	}

	/**
	 * @param trkRating initialize the rating for the current track
	 */
	public void setTrkRating(double trkRating) {
		this.trkRating = trkRating;
	}

	/**
	 * @return the initialized total number of times played as int
	 */
	public int getTrkPlaycount() {
		return trkPlaycount;
	}

	/**
	 * @param trkPlaycount initialize the playcount for the current track
	 */
	public void setTrkPlaycount(int trkPlaycount) {
		this.trkPlaycount = trkPlaycount;
	}

	/**
	 * @return the initialized trkGstArtst as String
	 */
	public String getTrkGstArtst() {
		return trkGstArtst;
	}

	/**
	 * @param trkGstArtst initialize the Guest artist for the track.
	 * @implNote If guest artist is not provided NULL will be handled instead of
	 *           empty string.
	 */
	public void setTrkGstArtst(String trkGstArtst) {
		if (trkGstArtst == "") {
			trkGstArtst = null;
		}
		this.trkGstArtst = trkGstArtst;
	}

	/**
	 * @return the string of Track objects seperated by ',' and dates are formated
	 *         by {@link SimpleDateFormat} with hh:mm
	 */
	@Override
	public String toString() {
		SimpleDateFormat lnthFmt = new SimpleDateFormat("hh:mm");
		return trkTitle + "," + trkArtist + "," + trkGstArtst + "," + trkLocation + "," + trkDate + ","
				+ lnthFmt.format(trkLength) + "," + trkSize + "," + trkRating + "," + trkPlaycount;
	}

}
