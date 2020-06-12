package ncl.ac.uk;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import ncl.ac.uk.service.BinPackInterface;
import ncl.ac.uk.service.TrackService;

public class BinPackaging implements BinPackInterface {
	/**
	 * Default no-arg constructor
	 */
	public BinPackaging() {
		super();
	}

	/**
	 * Method for bin packing problem used comparator interface to sort the valus
	 * Method overriden from {@link BinPackInterface} Run-time polymorphism
	 * 
	 * @param libObj
	 * @param libName
	 * @param binSize Algorithm for bin packing by First fit ascending - Sort the
	 *                list in an ascending order. - Get the total number of bins and
	 *                its capacity. - Insert the first data into bin and decrease
	 *                the available space in the current bin. - Check the next data
	 *                size with the available bin space. - If it fits then insert
	 *                into bin. And do the same step as above. - If it doesn't fit
	 *                use the next bin that is available. - If no bins are available
	 *                return the total sizes that has to be fitted. - Return the
	 *                bins with the data.
	 * 
	 * @return the number of bins required
	 */

	@Override
	public int pack(Library libObj, String libName, int binSize) {

		List<TrackService> trkData = libObj.getLibMp().get(libName);
		List<Double> trkSizes = new LinkedList<Double>();

		for (TrackService data : trkData) {
			trkSizes.add(data.getTrkSize());
		}

		// Implementation done using lambda expression
		Comparator<Double> c = (d1, d2) -> {
			return (d1 < d2) ? -1 : (d1 > d2) ? +1 : 0;
		};
		Collections.sort(trkSizes, c);

		int activeBin = 0;
		double newBinSize = binSize;

		activeBin++;
		double currentSize = newBinSize;
		for (double data : trkSizes) {

			if (data > currentSize) {
				currentSize = newBinSize - data;
				activeBin++;
			} else {
				currentSize -= data;
			}

		}
		return activeBin;
	}

}
