package ncl.ac.uk.service;

import java.util.List;

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

	public String getTrkTitle() {
		return trkTitle;
	}

	public void setTrkTitle(String trkTitle) {
		this.trkTitle = trkTitle;
	}
	

	public List<String> getTrkBandMem() {
		return trkBandMem;
	}


	public void setTrkBandMem(List<String> trkBandMem) {
		this.trkBandMem = trkBandMem;
	}


}
