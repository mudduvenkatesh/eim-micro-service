package net.trigyan.glide.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Value;
/**
 * Base Model
 * @author vmuddu
 *
 */
public class EIMModelBase extends AbstractEIMModel {

	public EIMModelBase() {
		super();
		
	}
	
	public EIMModelBase(IRI identifier, IRI baseType) {
		super(identifier, baseType);
	}

		
}
