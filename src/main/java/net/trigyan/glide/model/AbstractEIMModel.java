package net.trigyan.glide.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract Class for any EIM Model
 * 
 * @author vmuddu
 *
 */
public abstract class AbstractEIMModel implements EIMModel, Serializable {

	@Autowired
	ValueFactory valueFactory;

	public void setName(String name) {
		this.name = name;

	}

	private IRI identifier;
	private String label;
	private List<RDFProperty> properties;

	@Override
	public List<RDFProperty> getProperties() {
		return properties;
	}

	public AbstractEIMModel() {
		properties = new ArrayList<>();
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
	private String name;
	private IRI baseType;

	public AbstractEIMModel(IRI identifier, IRI baseType) {
		super();
		this.identifier = identifier;
		this.baseType = baseType;
	}

	@Override
	public IRI getIdentifier() {
		return identifier;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public IRI getBaseType() {
		return baseType;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public RDFProperty addProperty(IRI iri, Value value) {
		DefaultRDFProperty p = new DefaultRDFProperty(iri, value);
		this.properties.add(p);
		return p;
	}

	@Override
	public RDFProperty addProperty(IRI iri, String literal) {
		// TODO Auto-generated method stub
		Literal l = valueFactory.createLiteral(literal);
		return addProperty(iri, l);
	}

	@Override
	public String toString() {
		return "AbstractEIMModel [identifier=" + identifier + ", label=" + label + ", description=" + description
				+ ", name=" + name + ", baseType=" + baseType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
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
		AbstractEIMModel other = (AbstractEIMModel) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

}
