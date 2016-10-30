package net.trigyan.glide.spec.vocabulary;

import java.util.UUID;


import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * Default implementation for {@link IRIMintingService} interface
 * @author vmuddu
 *
 */

public class DefaultIRIMintingService implements IRIMintingService  {

	private ValueFactory valueFactory=null;
	
	public  DefaultIRIMintingService() {
		valueFactory=SimpleValueFactory.getInstance();
	}
	
	
	@Override
	public IRI mintSlashIRI(String baseIRI, Concept concept) {
		UUID identifier = getUUID();
		return  mintSlashIRI(baseIRI, concept,identifier.toString());
		
	}

	@Override
	public IRI mintHashIRI(String baseIRI, Concept concept) {
		UUID identifier = getUUID();
		return mintHashIRI(baseIRI, concept,identifier.toString());
	}
	
	
	@Override
	public IRI mintSlashIRI(String baseIRI, Concept concept, String identifier) {
		return  valueFactory.createIRI(
				String.format("%s/%s/%s", 
						baseIRI,concept.getType(),identifier.toString()));
	}
	
	@Override
	public IRI mintHashIRI(String baseIRI, Concept concept, String identifier) {
		return  valueFactory.createIRI(
				String.format("%s/%s#%s", 
						baseIRI,concept.getType(),identifier.toString()));
	}
	public UUID getUUID() {
		UUID identifier = UUID.randomUUID();
		return identifier;
	}


	@Override
	public IRI mintConceptHashIRI(String baseIRI, Concept concept) throws IllegalArgumentException {
		return  valueFactory.createIRI(
				String.format("%s#%s", 
						baseIRI,concept.getType()));
	}


	@Override
	public IRI mintConceptSlashIRI(String baseIRI, Concept concept) throws IllegalArgumentException {
		return  valueFactory.createIRI(
				String.format("%s/%s", 
						baseIRI,concept.getType()));
	}

}
