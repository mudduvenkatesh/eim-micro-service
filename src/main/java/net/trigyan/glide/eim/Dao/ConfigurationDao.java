package net.trigyan.glide.eim.Dao;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.trigyan.glide.repository.model.BaseConfiguration;
import net.trigyan.glide.repository.model.Configuration;

@Component
public class ConfigurationDao {

	@Autowired
	ValueFactory valueFactory;
	@Autowired
	RepositoryManager remoteRepositoryManager;
	@Autowired
	@Qualifier("eim-config")
	IRI eimConfiguratonContext;
	@Value("${glide.eim.repository.repo-id}")
	String eimRepositoryId;

	public Map<String,Configuration> getEIMConfiguration() {
		Map<String,Configuration> configs=new HashMap<>();
		String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ "PREFIX fibo-fnd-aap-agt:<http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/> "
				+ "PREFIX fibo-be-le-fbo:<http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/> "
				+ "PREFIX eim:<http://spec.trigyan.net/glide/EnterpriseInformationModel#> "
				+ "SELECT ?config ?configProperty ?configPropertyName ?configPropertyValue ?configLabel "
				+ "WHERE {?config rdf:type eim:EIMApplicationConfiguration. "
				+ "?config eim:hasConfigProperty ?configProperty. "
				+ "?configProperty	eim:configPropertyName ?configPropertyName. "
				+ "?configProperty eim:configPropertyValue ?configPropertyValue . "
				+ "?configProperty rdfs:label ?configLabel.}";
		Repository eimrepo = remoteRepositoryManager.getRepository(eimRepositoryId);
		try (RepositoryConnection conn = eimrepo.getConnection()) {
			TupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, query);
			TupleQueryResult result = tupleQuery.evaluate();
			while (result.hasNext()) { // iterate over the result
				BindingSet bindingSet = result.next();
				org.eclipse.rdf4j.model.Value eimPropertyName = bindingSet.getValue("configPropertyName");
				org.eclipse.rdf4j.model.Value eimPropertyValue=bindingSet.getValue("configPropertyValue");
				Configuration c = new BaseConfiguration(eimPropertyName,eimPropertyValue);
				configs.put(c.propertyName().stringValue(), c);				
			}
			conn.close();
		} catch (Exception e) {
			//TODO: exception management
		} finally {

		}
		return configs;
	}
}
