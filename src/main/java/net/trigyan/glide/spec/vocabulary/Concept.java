package net.trigyan.glide.spec.vocabulary;

/**
 * Interface to define a concept
 * Concept could be Org, place, people, person, thing, event..
 * @author vmuddu
 *
 */
public interface Concept  {
	/**
	 * Type of Type concept
	 * @return Name of the concept
	 */
	public String getType();
//	/**
//	 * fragment for the concept that is used to create the URI
//	 * @return fragment for the concept that is used to create the URI
//	 */
//	public String getFragment();
}
