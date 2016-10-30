package net.trigyan.glide.model;

import org.eclipse.rdf4j.model.IRI;
/**
 * Defines the class template for a EIM Organization for which all the EIM
 * models are linked and associated
 * @author vmuddu
 *
 */
public class Organization extends EIMModelBase {

	public Organization(IRI identifier, IRI baseType) {
		super(identifier, baseType);
	}

}
