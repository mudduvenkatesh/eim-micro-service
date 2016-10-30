package net.trigyan.glide.model;

/**
 * Factory to generate all Available EIM Models
 * @author vmuddu
 *
 */
public interface EIMModelFactory {

	/**
	 * Generate a Org
	 * @param baseIRI	A spec URI for this class
	 * @param id	Unique Identifier
	 * @param name	Name
	 * @param label	Label
	 * @return
	 */
	Organization createOrganization(String baseIRI,String id,String name,String label);
	/**
	 * Generate an Org - Mints a UUID for the Id
	 * @param baseIRI
	 * @param name
	 * @param label
	 * @return
	 */
	Organization createOrganization(String baseIRI,String name,String label);
	
}
