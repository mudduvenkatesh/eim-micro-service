package net.trigyan.glide.spec.vocabulary;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.GraphQuery;
import org.eclipse.rdf4j.query.GraphQueryResult;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.QueryResults;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.junit.Test;

public class CreateOrgTest {

//	@Test
//	public void test() {
//		// Should we create a IRI minting service??? based on a base url and
//		// some concept
//		String namespace = "http://mycompany.net";
//		Repository repo = new SailRepository(new MemoryStore());
//		repo.initialize();
//		ValueFactory f = repo.getValueFactory();
//		IRI fiboOrg = f.createIRI("http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/Organization/");
//		IRI org1 = f.createIRI(namespace + "/PCS#");
//		IRI org2 = f.createIRI(namespace + "/Risk#");
//		IRI org3 = f.createIRI(namespace + "/Finance#");
//		IRI org4 = f.createIRI(namespace + "/ESS#");
//
//		IRI partyApp = f.createIRI(namespace + "/PartyMaster#");
//
//		try (RepositoryConnection rc = repo.getConnection()) {
//			rc.add(org1, RDF.TYPE, fiboOrg);
//			rc.add(org1, RDFS.LABEL, f.createLiteral("Payments,Clearing and Settlements"));
//			rc.add(org2, RDF.TYPE, fiboOrg);
//			rc.add(org2, RDFS.LABEL, f.createLiteral("Risk"));
//			rc.add(org3, RDF.TYPE, fiboOrg);
//			rc.add(org3, RDFS.LABEL, f.createLiteral("Finance"));
//			rc.add(org4, RDF.TYPE, fiboOrg);
//			rc.add(org4, RDFS.LABEL, f.createLiteral("Enterprise Shared Services"));
//			// Create Party Master Application that belongs in ESS
//			rc.add(partyApp, RDF.TYPE, EIM.ANY_STANDARD_APPLICATION);
//			rc.add(partyApp, RDFS.LABEL, f.createLiteral("Enterprise Client Information -  Party Master"));
//			rc.add(partyApp, EIM.APPLICATION_ID, f.createLiteral("ECIF"));
//			rc.add(partyApp, EIM.APPLICATION_NAME, f.createLiteral("Enterprise Client Information File"));
//			rc.add(partyApp, EIM.IS_OWNED_BY, org4);
//			// Create a new DataDomain Under Party for this org
//			IRI partyDomain = f.createIRI(namespace + "#PartyMasterDomain");
//			rc.add(partyDomain, RDF.TYPE, EIM.MASTER_DATA);
//			rc.add(partyDomain, RDFS.LABEL, f.createLiteral("Party and Client Domain"));
//			// Create Data Elements
//			// partyId
//			IRI partyId = f.createIRI(namespace + "/partyId#");
//			rc.add(partyId, RDF.TYPE, EIM.DATA_ELEMENT);
//			IRI partyLegalName = f.createIRI(namespace + "/partyLegalName#");
//			rc.add(partyLegalName, RDF.TYPE, EIM.CRITICAL_DATA_ELEMENT);
//			IRI countryOfDomicile = f.createIRI(namespace + "/countryOfDomicile#");
//			rc.add(countryOfDomicile, RDF.TYPE, EIM.DATA_ELEMENT);
//			IRI countryOfInc = f.createIRI(namespace + "/countryOfInc#");
//			rc.add(countryOfInc, RDF.TYPE, EIM.DATA_ELEMENT);
//			IRI countryOfRisk = f.createIRI(namespace + "/countryOfRisk#");
//			rc.add(countryOfRisk, RDF.TYPE, EIM.CRITICAL_DATA_ELEMENT);
//
//			RepositoryResult<Statement> statements = rc.getStatements(null, null, null);
//			Model model = QueryResults.asModel(statements);
//			model.setNamespace("rdf", RDF.NAMESPACE);
//			model.setNamespace("rdfs", RDFS.NAMESPACE);
//			model.setNamespace("ex", namespace);
//			model.setNamespace("eim", EIM.NAMESPACE);
//
//			Rio.write(model, System.out, RDFFormat.RDFXML);
//
//		}
//
//	}
//
//	@Test
//	public void testAddOrgToRepo() {
//		String rdf4jServer = "http://localhost:7200/";
//		String repositoryID = "EnterpriseInformationModel";
//		Repository repo = new HTTPRepository(rdf4jServer, repositoryID);
//		repo.initialize();
//		try (RepositoryConnection conn = repo.getConnection()) {
//			System.out.println(conn.isOpen());
//			String namespace = "http://spec.mycompany.net";
//			ValueFactory f = repo.getValueFactory();
//			// IRI fiboOrg =
//			// f.createIRI("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
//			// IRI org1 = f.createIRI(namespace + "/PCS#");
//			// IRI org2 = f.createIRI(namespace + "/Risk#");
//			// IRI org3 = f.createIRI(namespace + "/Finance#");
//			// get org4 from DB
//
//			IRI org4 = f.createIRI(namespace + "/ESS#");
//			// System.out.println(org4);
//			// conn.add(org1, RDF.TYPE, fiboOrg);
//			// conn.add(org1, RDFS.LABEL, f.createLiteral("Payments,Clearing and
//			// Settlements"));
//			// conn.add(org2, RDF.TYPE, fiboOrg);
//			// conn.add(org2, RDFS.LABEL, f.createLiteral("Risk"));
//			// conn.add(org3, RDF.TYPE, fiboOrg);
//			// conn.add(org3, RDFS.LABEL, f.createLiteral("Finance"));
//			// conn.add(org4, RDF.TYPE, fiboOrg);
//			// conn.add(org4, RDFS.LABEL, f.createLiteral("Enterprise Shared
//			// Services"));
//			// IRI test = FOAF.BIRTHDAY;
//			IRI partyApp = f.createIRI(namespace + "/PartyMaster#");
//			// conn.add(partyApp, RDF.TYPE,EIM.ANY_STANDARD_APPLICATION);
//			// conn.add(partyApp,RDFS.LABEL,f.createLiteral("Enterprise Client
//			// Information - Party Master"));
//			// conn.add(partyApp,EIM.APPLICATION_ID,f.createLiteral("ECIF"));
//			// conn.add(partyApp,EIM.APPLICATION_NAME,f.createLiteral("Enterprise
//			// Client Information File"));
//			// conn.add(partyApp, EIM.IS_OWNED_BY,org4);
//			// conn.commit();
//			IRI partyDomain = f.createIRI(namespace + "#PartyMasterDomain");
//			conn.add(partyDomain, RDF.TYPE, EIM.MASTER_DATA);
//			conn.add(partyDomain, RDFS.LABEL, f.createLiteral("Party and Client Domain"));
//			// Create Data Elements
//			// partyId
//			IRI partyId = f.createIRI(namespace + "/partyId#");
//			conn.add(partyId, RDF.TYPE, EIM.DATA_ELEMENT);
//			conn.add(partyId, EIM.DATA_CLASSIFIED_BY, partyDomain);
//			conn.add(partyId, EIM.IS_PROVISIONED_BY, partyApp);
//			IRI partyLegalName = f.createIRI(namespace + "/partyLegalName#");
//			conn.add(partyLegalName, RDF.TYPE, EIM.CRITICAL_DATA_ELEMENT);
//			conn.add(partyLegalName, EIM.DATA_CLASSIFIED_BY, partyDomain);
//			conn.add(partyLegalName, EIM.IS_PROVISIONED_BY, partyApp);
//			IRI countryOfDomicile = f.createIRI(namespace + "/countryOfDomicile#");
//			conn.add(countryOfDomicile, RDF.TYPE, EIM.DATA_ELEMENT);
//			conn.add(countryOfDomicile, EIM.DATA_CLASSIFIED_BY, partyDomain);
//			conn.add(countryOfDomicile, EIM.IS_PROVISIONED_BY, partyApp);
//			IRI countryOfInc = f.createIRI(namespace + "/countryOfInc#");
//			conn.add(countryOfInc, RDF.TYPE, EIM.DATA_ELEMENT);
//			conn.add(countryOfInc, EIM.DATA_CLASSIFIED_BY, partyDomain);
//			conn.add(countryOfInc, EIM.IS_PROVISIONED_BY, partyApp);
//			IRI countryOfRisk = f.createIRI(namespace + "/countryOfRisk#");
//			conn.add(countryOfRisk, RDF.TYPE, EIM.CRITICAL_DATA_ELEMENT);
//			conn.add(countryOfRisk, EIM.DATA_CLASSIFIED_BY, partyDomain);
//			conn.add(countryOfRisk, EIM.IS_PROVISIONED_BY, partyApp);
//
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//
//	}
//
//	@Test
//	public void testAddHRMSApp() {
//
//	}
//
//	@Test
//	public void testOrgQueryStatement() {
//		String rdf4jServer = "http://localhost:7200/";
//		String repositoryID = "EnterpriseInformationModel";
//		Repository repo = new HTTPRepository(rdf4jServer, repositoryID);
//		repo.initialize();
//		try (RepositoryConnection conn = repo.getConnection()) {
//			// Get companies
//			ValueFactory f = repo.getValueFactory();
//			// object
//			IRI fiboOrg = f
//					.createIRI("http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/Organization/");
//			// predicate is RDF.TYPE
//			RepositoryResult<Statement> statements = conn.getStatements(null, RDF.TYPE, fiboOrg);
//			List<Statement> orgs = statements.asList();
//			orgs.stream().map(st -> st.getSubject()).forEach(System.out::println);
//			conn.close();
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//
//	}
//
//	@Test
//	public void testOrgQueryStatement1() {
//
//		String rdf4jServer = "http://localhost:7200/";
//		String repositoryID = "EnterpriseInformationModel";
//		Repository repo = new HTTPRepository(rdf4jServer, repositoryID);
//		repo.initialize();
//		String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
//				+ "prefix onto:<http://www.ontotext.com/> "
//				+ "prefix rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
//				+ "prefix eim:<http://spec.trigyan.net/glide/EnterpriseInformationModel#> "
//				+ "prefix fibo-org:<http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/> "
//				+ "select * where { " + "?id rdf:type fibo-org:Organization . " + "OPTIONAL {?id rdfs:label ?label .} "
//				+ "OPTIONAL {?id eim:hasName ?name . } " + "OPTIONAL {?id eim:hasDescription ?desc .} " + "} ";
//		try (RepositoryConnection conn = repo.getConnection()) {
//			// conn.pre
//			TupleQuery qq = conn.prepareTupleQuery(QueryLanguage.SPARQL, query);
//			TupleQueryResult qqr = qq.evaluate();
//			List<BindingSet> results = QueryResults.stream(qqr).collect(Collectors.toList());
//			System.out.println(results.size());
//			//if (!results.isEmpty() && results.size() == 1) {
//				// log and throw error
//				System.out.println(results.get(0).getValue("id"));
//				System.out.println(results.get(0).getValue("name"));
//				System.out.println(results.get(0).getValue("desc"));
//				System.out.println(results.get(0).getValue("label").stringValue());
//			//}
//		}
//	}

}
