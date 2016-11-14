package net.trigyan.glide.repository.model;

import org.eclipse.rdf4j.model.Value;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(using = ConfigurationSerializer.class)
public class BaseConfiguration extends AbstractConfiguration {

	public BaseConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseConfiguration(Value propertyName, Value propertyValue) {
		super(propertyName, propertyValue);
	}
	
}
