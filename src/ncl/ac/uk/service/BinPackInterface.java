package ncl.ac.uk.service;

import ncl.ac.uk.Library;

/**
 * Provides fucntionality to bin packaging method
 */
public interface BinPackInterface {

	int pack(Library libObj, String libName, int binSize);

}
