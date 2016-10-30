package net.trigyan.glide.spec.vocabulary;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.RDF4JException;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.SKOS;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.junit.Test;

public class FIBOOrgTest {

	@Test
	public void testCreateFormalOrg() {
		ModelBuilder builder = new ModelBuilder();
		String companyBase = "http://spec.mycompany.net#";
		ValueFactory factory = SimpleValueFactory.getInstance();
		IRI myBank = factory.createIRI(companyBase + "MyEnterpriseBank");
		
		// Sector Resource
		IRI mysector = factory.createIRI(companyBase + "Sector");
		//sectors
		IRI imSector = factory.createIRI(companyBase + "Investment-Management");
		IRI isSector = factory.createIRI(companyBase + "Investment-Services");
		IRI mgSector = factory.createIRI(companyBase + "Markets-Group");
		IRI ssSector = factory.createIRI(companyBase + "Shared-Services-and-Other-Activities");
		IRI imSectorIdentifier = factory.createIRI(companyBase + "Sector-" + "AMSEC0");
		IRI isSectorIdentifier = factory.createIRI(companyBase + "Sector-" + "SECSRV");
		IRI mgSectorIdentifier = factory.createIRI(companyBase + "Sector-" + "MKTGRP_BPM");
		IRI otherSectorIdentifier = factory.createIRI(companyBase + "Sector-" + "OTHSEC");
		
		//business Units
		IRI buType = factory.createIRI(companyBase + "Business-Unit");
		IRI bpBu = factory.createIRI(companyBase + "Business-Partners");
		IRI bpBuIdentifier = factory.createIRI(companyBase,"BusinessUnit-"+"TSHSER");
		IRI ctsBu=factory.createIRI(companyBase+"Client-Technology-Services");
		IRI ctsBuId = factory.createIRI(companyBase,"BusinessUnit-"+"TOTECH");
		
		//BU Resource
		
		// set some namespaces
		// String fiboFndOrgFmUri
		// ="http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/";
		// String
		// fiboFndAapAgt="http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/";
		// String fiboFndAapAgtPrefix = "fibo-fnd-aap-agt";
		// IRI fiboFndOrgFmIri = factory.createIRI(fiboFndOrgFmUri +
		// "FormalOrganization");
		// IRI hasNameIRI = factory.createIRI(fiboFndAapAgt+"hasName");
		builder.setNamespace("my-org", companyBase).setNamespace(FiboOrganizations.PREFIX, FiboOrganizations.NAMESPACE)
				.setNamespace("rdfs", RDFS.NAMESPACE).setNamespace(FiboAgents.PREFIX, FiboAgents.NAMESPACE)
				.setNamespace(FiboLeFBO.PREFIX, FiboLeFBO.NAMESPACE)
				.setNamespace(FiboFormalOrganizations.PREFIX, FiboFormalOrganizations.NAMESPACE)
				.setNamespace(EIM.PREFIX, EIM.NAMESPACE)
				.setNamespace(SKOS.PREFIX,SKOS.NAMESPACE);
		
		IRI myAppESS = factory.createIRI(EIM.NAMESPACE + "ESS");
		IRI partyDataDomain = factory.createIRI(companyBase + "PartyMasterDataDomain");
		builder.namedGraph("my-org:eim-graph-v1") // add a new named graph to
													// the model
				.subject(myBank) 
				
				
				.add(RDF.TYPE, FiboFormalOrganizations.FormalOrganization)
				.add(RDFS.LABEL, "MyEnterpriseBank").add(FiboAgents.hasName, "MyEnterpriseBank");
				builder  = addSector(builder,companyBase);
				//sector Identifier
				builder.subject(imSectorIdentifier).add(RDFS.LABEL, "AMSEC0");
				builder.subject(isSectorIdentifier).add(RDFS.LABEL, "SECSRV");
				builder.subject(mgSectorIdentifier).add(RDFS.LABEL, "MKTGRP_BPM");
				builder.subject(otherSectorIdentifier).add(RDFS.LABEL, "OTHSEC");		
				builder.subject(imSector).add(RDF.TYPE, mysector)
					.add(FiboLeFBO.isSubUnitOf, myBank)
					.add(FiboAgents.isIdentifiedBy, imSectorIdentifier)
					.add(FiboAgents.hasName, "Investment-Management");
				builder.subject(isSector).add(RDF.TYPE, mysector)
					.add(FiboLeFBO.isSubUnitOf, myBank)
					.add(FiboAgents.isIdentifiedBy, isSectorIdentifier)
					.add(FiboAgents.hasName, "Investment-Services");
				builder.subject(mgSector).add(RDF.TYPE, mysector)
					.add(FiboLeFBO.isSubUnitOf, myBank)
					.add(FiboAgents.isIdentifiedBy, mgSectorIdentifier)
					.add(FiboAgents.hasName, "Markets-Group");
				
				builder.subject(ssSector)
					.add(RDF.TYPE, mysector)
					.add(FiboLeFBO.isSubUnitOf, myBank)
					.add(FiboAgents.isIdentifiedBy, otherSectorIdentifier)
					.add(FiboAgents.hasName, "Shared-Services-and-Other-Activities");
				builder = addBu(builder,companyBase);
				builder.subject(bpBuIdentifier).add(RDFS.LABEL, "TSHSER");
				builder.subject(bpBu).add(RDF.TYPE, buType).add(FiboLeFBO.isSubUnitOf, ssSector)
				.add(FiboAgents.isIdentifiedBy, bpBuIdentifier)
				.add(FiboAgents.hasName, "BUSINESS PARTNERS");
				builder.subject(ctsBuId).add(RDFS.LABEL, "TOTECH");
				builder.subject(ctsBu).add(RDF.TYPE, buType).add(FiboLeFBO.isSubUnitOf, ssSector)
				.add(FiboAgents.isIdentifiedBy,ctsBuId);
				//add Corp Trust Bu
				addBuUnit(factory,builder, companyBase,"Corporate-Trust","CPTRST",buType,isSector);
				addBuUnit(factory,builder, companyBase,"Asset-Servicing","ASJPTK",buType,isSector);
				addBuUnit(factory,builder, companyBase,"Broker-Dealer-Services","K01007",buType,isSector);
				addApp(factory, builder, companyBase, 
						"TRANSFER-OF-ASSETS", "TRANSFER OF ASSETS", "TOA", factory.createIRI(companyBase +"Asset-Servicing"));
				addApp(factory, builder, companyBase, 
						"TRANSFER-OF-ASSETS", "TRANSFER OF ASSETS", "TOA", factory.createIRI(companyBase+"Asset-Servicing"));
				addApp(factory, builder, companyBase, 
						"REPO-EDGE-APPLICATION", "REPO EDGE APPLICATION", "RPO", factory.createIRI(companyBase+"Corporate-Trust"));
				addApp(factory, builder, companyBase, 
						"Enterprise-Risk-Management-Platform-(MARS)", "Enterprise Risk Management Platform (MARS)", "ERI", 
						bpBu);
				
				
				builder.subject(EIM.PREFIX + ":" + "ECIF").add(RDF.TYPE, EIM.ANY_STANDARD_APPLICATION)
				.add(RDFS.LABEL, "Enterprise Client Information File").add(EIM.HAS_CODE, "ECIF")
				.add(EIM.HAS_NAME, "ECIF").add(EIM.IS_OWNED_BY, factory.createIRI(companyBase+"Corporate-Trust"));
				builder.subject("my-org:PartyDataDomain").add(RDF.TYPE, EIM.MASTER_DATA)
					.add(RDFS.LABEL, "Party Data Domain");
				builder.subject("my-org:HRDataDomain").add(RDF.TYPE, EIM.MASTER_DATA);
				builder.subject(EIM.PREFIX + ":" + "PartyId").add(RDF.TYPE, EIM.DATA_ELEMENT)
				.add(RDFS.LABEL, "Party Identifier").add(EIM.HAS_ID, "PartyId").add(EIM.HAS_NAME, "Party Identifier")
				.add(EIM.DATA_CLASSIFIED_BY, partyDataDomain);
				builder.subject(EIM.PREFIX + ":" + "PartyName")
				.add(RDF.TYPE, EIM.DATA_ELEMENT).add(RDFS.LABEL, "Party Name").add(EIM.HAS_ID, "PartyName")
				.add(EIM.DATA_CLASSIFIED_BY, partyDataDomain);
				builder.subject(EIM.PREFIX + ":" + "CountryOfRisk")
				.add(RDF.TYPE, EIM.CRITICAL_DATA_ELEMENT).add(RDFS.LABEL, "Country Of Risk").add(EIM.HAS_ID, "CountryOfRisk")
				.add(EIM.DATA_CLASSIFIED_BY, partyDataDomain);
				

		// add a triple to the default graph
		builder.defaultGraph().add("my-org:eim-graph-v1", RDF.TYPE, "my-org:Graph");

		// return the Model object
		Model m = builder.build();
		// Rio.write(m, System.out, RDFFormat.TURTLE);
		// Create a new Mem repo
		File dataDir= new File("./target/data/MyRepo");
		File rdfFile = new File("./target/test.rdf");
		MemoryStore memStore = new MemoryStore(dataDir);
		memStore.setSyncDelay(1000L);
		Repository repo = new SailRepository(memStore);
		repo.initialize();
		
		// File rdfFile = new File(dataDir, "test.ttl");
		
		// try (RepositoryConnection con = repo.getConnection()) {
		try {
			FileOutputStream fs = new FileOutputStream(rdfFile);
			Rio.write(m, fs, RDFFormat.RDFXML);
			fs.close();
			// con.add(rdfFile, companyBase, RDFFormat.TURTLE);

			// search

			// con.close();
			// } catch (RDF4JException e) {
			// handle exception. This catch-clause is
			// optional since RDF4JException is an unchecked exception
		} catch (IOException e) {
			System.out.println(e);
			// handle io exception
		} catch (Exception e) {
			System.out.println(e);
		}
		// m.stream().filter(statement->statement.getObject())
		// FileOutputStream out;
		// try {
		// m.stream().
		// //out = new FileOutputStream("testfile.rdf");
		// Rio.write(m, out, RDFFormat.TURTLE);
		// out.close();
		// } catch ( IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
	
	private ModelBuilder addSector(ModelBuilder mb,String companyBase) {
		mb.subject(companyBase + "Sector")
			.add(RDFS.SUBCLASSOF,FiboLeFBO.OrganizationalSubUnit)
			.add(RDFS.LABEL, "Sector")
			.add(SKOS.DEFINITION, "Definition of Sector");
		return mb;
		
	}
	private ModelBuilder addBu(ModelBuilder mb,String companyBase) {
		mb.subject(companyBase + "Business-Unit")
			.add(RDFS.SUBCLASSOF,FiboLeFBO.OrganizationalSubUnit)
			.add(RDFS.LABEL, "Business Unit")
			.add(SKOS.DEFINITION, "Definition of Business Unit");
		return mb;
		
	}
	
	private ModelBuilder addBuUnit(ValueFactory factory,ModelBuilder mb,String companyBase,String buName,String buId,
			IRI subjectType,IRI subUnit) {
		String buName2=buName.replace("-", " ");
		IRI bpBu = factory.createIRI(companyBase + buName);
		IRI bpBuIdentifier = factory.createIRI(companyBase,"BusinessUnit-"+buId);
		mb.subject(bpBu).add(RDF.TYPE, subjectType).add(FiboLeFBO.isSubUnitOf, subUnit)
		.add(FiboAgents.isIdentifiedBy, bpBuIdentifier)
		.add(FiboAgents.hasName, buName2);
		return mb;
	}
	private ModelBuilder addApp(ValueFactory factory,ModelBuilder mb,String companyBase,
			String subjectName,
			String appName,String appid,
			IRI ownedBy) {
		mb.subject(EIM.PREFIX + ":" + subjectName).add(RDF.TYPE, EIM.ANY_STANDARD_APPLICATION)
		.add(RDFS.LABEL, appName).add(EIM.HAS_CODE, appid)
		.add(EIM.HAS_NAME, appName).add(EIM.IS_OWNED_BY, ownedBy);
		
		return mb;
	}
	//private ModelBuild addBusinessTerm(ValueFactory factory,ModelBuilder mb,String companyBase,)

}
