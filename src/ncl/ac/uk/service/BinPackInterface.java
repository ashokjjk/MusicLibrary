package ncl.ac.uk.service;

import ncl.ac.uk.BinPackaging;
import ncl.ac.uk.Library;

/**
 * Provides fucntionality to bin packaging method
 * @implSpec {@link BinPackaging}
 */
public interface BinPackInterface {

	int pack(Library libObj, String libName, int binSize);

}
