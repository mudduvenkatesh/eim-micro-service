package net.trigyan.glide.repository.model;

import org.eclipse.rdf4j.model.Value;

public class AbstractConfiguration implements Configuration {
	
	
	Value propertyName;
	Value propertyValue;

	
	public AbstractConfiguration() {
		super();
		
		
		
	}
	public AbstractConfiguration(Value propertyName, Value propertyValue) {
		this();
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}
	@Override
	public String toString() {
		return "AbstractConfiguration [propertyName=" + propertyName + ", propertyValue=" + propertyValue + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractConfiguration other = (AbstractConfiguration) obj;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	}
	@Override
	public Value propertyName() {
		
		return propertyName;
	}

	@Override
	public Value propertyValue() {
		return propertyValue;
	}

}
