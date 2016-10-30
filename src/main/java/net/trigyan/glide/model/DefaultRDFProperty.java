package net.trigyan.glide.model;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Value;

public class DefaultRDFProperty implements RDFProperty {

	private IRI iri;
	private Value value;
	
	public  DefaultRDFProperty(IRI iri,Value value) {
		super();
		this.iri=iri;
		this.value=value;
		
	}
	@Override
	public IRI getIRI() {
		return iri;
	}

	@Override
	public Value getValue() {
		return value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iri == null) ? 0 : iri.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		DefaultRDFProperty other = (DefaultRDFProperty) obj;
		if (iri == null) {
			if (other.iri != null)
				return false;
		} else if (!iri.equals(other.iri))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DefaultRDFProperty [iri=" + iri + ", value=" + value + "]";
	}

}
