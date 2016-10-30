package net.trigyan.glide.model;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Value;

public interface RDFProperty {

	IRI getIRI();
	Value getValue();
}
