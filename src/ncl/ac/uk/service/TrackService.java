package ncl.ac.uk.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TrackService {

	private String trkTitle, trkArtist, trkLocation, trkGstArtst;
	private Date trkLength,trkDate;
	private double trkSize, trkRating;
	private int trkPlaycount;

	public TrackService() {

	}

	public TrackService(String trkTitle, String trkArtist, String trkGstArtst, Date trkDate, Date trkLength, double trkRating,
			String trkLocation, double trkSize, int trkPlaycount) {
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

	public String getTrkTitle() {
		return trkTitle;
	}

	public void setTrkTitle(String trkTitle) {
		this.trkTitle = trkTitle;
	}

	public String getTrkArtist() {
		return trkArtist;
	}

	public void setTrkArtist(String trkArtist) {
		this.trkArtist = trkArtist;
	}

	public String getTrkLocation() {
		return trkLocation;
	}

	public void setTrkLocation(String trkLocation) {
		this.trkLocation = trkLocation;
	}

	public Date getTrkDate() {
		return trkDate;
	}

	public void setTrkDate(Date trkDate) {
		this.trkDate = trkDate;
	}

	public Date getTrkLength() {
		return trkLength;
	}

	public void setTrkLength(Date trkLength) {
		this.trkLength = trkLength;
	}

	public double getTrkSize() {
		return trkSize;
	}

	public void setTrkSize(double trkSize) {
		this.trkSize = trkSize;
	}

	public double getTrkRating() {
		return trkRating;
	}

	public void setTrkRating(double trkRating) {
		this.trkRating = trkRating;
	}

	public int getTrkPlaycount() {
		return trkPlaycount;
	}

	public void setTrkPlaycount(int trkPlaycount) {
		this.trkPlaycount = trkPlaycount;
	}

	public String getTrkGstArtst() {
		return trkGstArtst;
	}

	public void setTrkGstArtst(String trkGstArtst) {
		if(trkGstArtst=="") {
			trkGstArtst=null;
		}
		this.trkGstArtst = trkGstArtst;
	}

	@Override
	public String toString() {
		SimpleDateFormat lnthFmt = new SimpleDateFormat("hh:mm");
		return trkTitle + "," + trkArtist + "," + trkGstArtst + "," + trkLocation + "," + trkDate + "," + lnthFmt.format(trkLength) + ","
				+ trkSize + "," + trkRating + "," + trkPlaycount;
	}

}
