package net.trigyan.glide.model;

import java.util.List;
import java.util.Map;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Value;
/**
 * All Data Models in the EIM space will implement this interface
 * @author vmuddu
 *
 */
public interface EIMModel {
	/**
	 * Unique Minted Identifier for model
	 * @return A unique IRI
	 */
	IRI getIdentifier();
	/**
	 * Label 
	 * @return
	 */
	String getLabel();
	/**
	 * Base Type for this Item
	 * @return
	 */
	IRI getBaseType();
	/**
	 * Name
	 * @return
	 */
	String getName();
	/**
	 * Description
	 * @return
	 */
	String getDescription();
	
	
	List<RDFProperty> getProperties();
	
	RDFProperty addProperty(IRI iri, Value value);
	RDFProperty addProperty(IRI iri, String literal);
	
	
	
	
	
	
}
