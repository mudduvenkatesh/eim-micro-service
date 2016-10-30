package net.trigyan.glide.Dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.GraphQuery;
import org.eclipse.rdf4j.query.GraphQueryResult;
import org.eclipse.rdf4j.query.Query;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.QueryResults;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.trigyan.glide.model.Organization;

@Component
public class OrganizationDAO {

	@Autowired
	Repository graphDBRepository;
	@Autowired
	ValueFactory valueFactory;

	public Organization getOrganization(IRI identifier) {
		IRI baseType = valueFactory
				.createIRI("http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/Organization");
		String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "prefix onto:<http://www.ontotext.com/> "
				+ "prefix rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "prefix eim:<http://spec.trigyan.net/glide/EnterpriseInformationModel#> "
				+ "prefix fibo-org:<http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/> "
				+ "select * where { " + "?id rdf:type fibo-org:Organization . " + "OPTIONAL {?id rdfs:label ?label .} "
				+ "OPTIONAL {?id eim:hasName ?name . } " + "OPTIONAL {?id eim:hasDescription ?desc .} " + "} ";
		try (RepositoryConnection conn = graphDBRepository.getConnection()) {
			// conn.pre
			TupleQuery qq = conn.prepareTupleQuery(QueryLanguage.SPARQL, query);
			TupleQueryResult qqr = qq.evaluate();
			List<BindingSet> results = QueryResults.stream(qqr).collect(Collectors.toList());
			// System.out.println(results.size());
			if (!results.isEmpty() && results.size() == 1) {
				IRI id = valueFactory.createIRI(results.get(0).getValue("id").stringValue());
				Organization org = new Organization(id, baseType);
				org.eclipse.rdf4j.model.Value name = results.get(0).getValue("name");
				if (name != null) {
					org.setName(name.stringValue());
				}
				org.eclipse.rdf4j.model.Value desc = results.get(0).getValue("desc");
				if (desc != null) {
					org.setDescription(desc.stringValue());
				}

				org.eclipse.rdf4j.model.Value label = results.get(0).getValue("label");
				if (label != null) {
					org.setLabel(label.stringValue());
				}

				return org;
			}

		}
		return null;
	}

	List<Organization> getOrganizations() {
		return null;
	}

}
