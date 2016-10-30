package net.trigyan.glide.model;

import org.eclipse.rdf4j.model.IRI;
import org.springframework.beans.factory.annotation.Autowired;

import net.trigyan.glide.spec.vocabulary.Concept;
import net.trigyan.glide.spec.vocabulary.DefaultConcept;
import net.trigyan.glide.spec.vocabulary.FiboFormalOrganizations;
import net.trigyan.glide.spec.vocabulary.IRIMintingService;
/**
 * Default implementation of the {@link EIMModelFactory}
 * @author vmuddu
 *
 */
public class SimpleEIMModelFactory implements EIMModelFactory {

	static final Concept orgConcept;
	static {
		orgConcept=new DefaultConcept("Organization");
	}
	@Autowired
	IRIMintingService iriMintingService;
	
	
	@Override
	public Organization createOrganization(String baseIRI, String id, String name, String label) {
		IRI orgIRI = iriMintingService.mintHashIRI(baseIRI, orgConcept,id);
		Organization org = new Organization(orgIRI, FiboFormalOrganizations.FormalOrganization);
		org.setName(name);
		org.setLabel(label);
		return org;
	}

	@Override
	public Organization createOrganization(String baseIRI, String name, String label) {
		// TODO Auto-generated method stub
		return null;
	}

}
