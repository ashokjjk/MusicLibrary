package ncl.ac.uk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ncl.ac.uk.service.AlbumService;

public class AddAlbum {

	private List<AlbumService> albmLst = new ArrayList<AlbumService>();
	Map<String, List<String>> albmTrkLst = new LinkedHashMap<String, List<String>>();

	public List<AlbumService> getAlbmLst() {
		return albmLst;
	}

	public void setAlbmLst(List<AlbumService> albmLst) {
		this.albmLst = albmLst;
	}

	public Map<String, List<String>> getAlbmTrkLst() {
		return albmTrkLst;
	}

	public void setAlbmTrkLst(Map<String, List<String>> albmTrkLst) {
		this.albmTrkLst = albmTrkLst;
	}

	public void addAlbm(String albName, String albType, String albArtist) {

		AlbumService albsrvcObj = new AlbumService(albName, albType, albArtist);
		albmLst.add(albsrvcObj);

	}

	public void addTracksToAlbum(String albmName, List<String> trkNames) {

		try {
			Map<String, List<String>> mp = new HashMap<String, List<String>>();
			mp.put(albmName, trkNames);
			setAlbmTrkLst(mp);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
