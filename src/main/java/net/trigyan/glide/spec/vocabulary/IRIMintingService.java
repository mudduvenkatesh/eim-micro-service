package net.trigyan.glide.spec.vocabulary;

import org.eclipse.rdf4j.model.IRI;

/**
 * 
 * A service for creating {@link IRI IRIs}
 * @author vmuddu
 * 
 * @see	<a href="http://www.w3Id.org">http://www.w3Id.org</a>
 * @see <a href="http://patterns.dataincubator.org/book/identifier-patterns.html"">Identifier Patterns</a
 */
public interface IRIMintingService {

	/**
	 * Creates a new slash IRI for Instance of a concept from the supplied arguments
	 * 
	 * @param baseNamespace
	 *        	A string-representation of a basenamespace IRI.
	 * @param concept 
	 * 			the fragment to be linked to base IRI
	 * @param identifier 
	 * 			additional internal identifier provided by the caller
	 * @return An object representing the IRI.
	 * @throws IlllegalArgumentException
	 *         If the supplied string does not resolve to a legal (absolute) IRI.
	 */
	IRI mintSlashIRI(String baseIRI,Concept concept,String identifier) throws IllegalArgumentException;
	
	/**
	 * Creates a new hash IRI for instance of a concept from the supplied arguments
	 * 
	 * @param baseIRI
	 *        	A string-representation of a baseIRI.
	 * @param concept 
	 * 			the fragment to be linked to base IRI
	 * @param identifier 
	 * 			additional internal identifier provided by the caller
	 * @return An object representing the IRI.
	 * @throws IlllegalArgumentException
	 *         If the supplied string does not resolve to a legal (absolute) IRI.
	 */
	IRI mintHashIRI(String baseIRI,Concept concept,String identifier) throws IllegalArgumentException;
	/**
	 * Creates a new slash IRI for instance of a concept from the supplied arguments, a random UUID is used for identifier
	 * 
	 * @param baseIRI
	 *        	A string-representation of a baseIRI.
	 * @param concept 
				the fragment to be linked to base IRI
				
	 * @return An object representing the IRI.
	 * @throws IlllegalArgumentException
	 *         If the supplied string does not resolve to a legal (absolute) IRI.
	 */
	IRI mintSlashIRI(String baseIRI,Concept concept) throws IllegalArgumentException;
	/**
	 * Creates a new slash IRI for instance of concept from the supplied arguments, a random UUID is used for identifier
	 * 
	 * @param baseIRI
	 *        	A string-representation of a baseIRI.
	 * @param concept 
				the fragment to be linked to base IRI
	 * @return An object representing the IRI.
	 * @throws IlllegalArgumentException
	 *         If the supplied string does not resolve to a legal (absolute) IRI.
	 */
	IRI mintHashIRI(String baseIRI,Concept concept) throws IllegalArgumentException;
	
	/**
	 * Creates a new hash IRI for the concept from the supplied arguments
	 * @param baseIRI	String representation of the base Namespace
	 * @param concept	The concept fragment
	 * @return An Object representing to be linked to base IRI
	 * @throws IllegalArgumentException
	 */
	IRI mintConceptHashIRI(String baseIRI,Concept concept) throws IllegalArgumentException;
	
	/**
	 * Creates a new slash IRI for the concept from the supplied arguments
	 * @param baseIRI	String representation of the base Namespace
	 * @param concept	The concept fragment
	 * @return An Object representing to be linked to base IRI
	 * @throws IllegalArgumentException
	 */
	
	IRI mintConceptSlashIRI(String baseIRI,Concept concept) throws IllegalArgumentException;
}
