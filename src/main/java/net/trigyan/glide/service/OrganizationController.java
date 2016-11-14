package net.trigyan.glide.service;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import net.trigyan.glide.Dao.OrganizationDAO;
import net.trigyan.glide.model.Organization;



@RestController
public class OrganizationController {

	@Autowired
	OrganizationDAO dao;
	
	@Autowired
	ValueFactory valueFactory;
	
//	@Value("${glide.eim.baseIri}")
//	String baseCompanyUri;

//	@RequestMapping(value = "/organization",method = RequestMethod.GET)
//	public Organization getOrganization(
//			@RequestParam(value = "name", defaultValue = "http://example.org") String name) {
//		//Get the Base IRI
//		String fullIRIString = name;
//		IRI orgIRI = valueFactory.createIRI(fullIRIString);
//		return dao.getOrganization(orgIRI);
//		//return null;
//	}

}
