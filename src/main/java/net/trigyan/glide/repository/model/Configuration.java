package net.trigyan.glide.repository.model;

import org.eclipse.rdf4j.model.Value;

public interface Configuration {

	public final String baseIRIPropertyName="Base IRI";
	public final String companyNameProperty = "companyName";
	public final String programNameProperty="programName";
	public Value propertyName();
	public Value propertyValue();
	
}
