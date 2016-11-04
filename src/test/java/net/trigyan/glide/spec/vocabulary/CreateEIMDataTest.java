package net.trigyan.glide.spec.vocabulary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateEIMDataTest {

//	private final Logger logger = LoggerFactory.getLogger(CreateEIMDataTest.class);
//
//	@Test
//	public void testCreateBaseData() {
//		ModelBuilder builder = new ModelBuilder();
//		String companyBase = "http://spec.mycompany.net";
//		ValueFactory factory = SimpleValueFactory.getInstance();
//		Concept myOrg = new DefaultConcept("MyEnterpriseBank");
//		Concept sector = new DefaultConcept("Sector");
//		Concept bu = new DefaultConcept("Business-Unit");
//		IRIMintingService minter = new DefaultIRIMintingService();
//		IRI sectorIRI = minter.mintConceptHashIRI(companyBase, sector);
//		IRI buIRI = minter.mintConceptHashIRI(companyBase, bu);
//		IRI myOrgIRI = minter.mintConceptHashIRI(companyBase, myOrg);
//		logger.info(sectorIRI.stringValue());
//		logger.info(buIRI.stringValue());
//		logger.info(myOrgIRI.toString());
//		List<IRI> buIRIs = getBU()
//				.stream()
//				.map((bu1)->minter.mintHashIRI(companyBase, bu,bu1.getKey())).collect(Collectors.toList());
//		buIRIs.stream().forEach((iri)->logger.info(iri.stringValue()));
//	}
//	IRI createBUInstance(String companyBase, Concept c, IRIMintingService minter, String id) {
//		return minter.mintHashIRI(companyBase, c, id);
//	}
//	List<KeyValue> getBU() {
//		List<KeyValue> buList = new ArrayList<>();
//		buList.add(new KeyValue("TSHSER","Business-Partners"));
//		buList.add(new KeyValue("TOTECH","Client-Technology-Services"));
//		buList.add(new KeyValue("CPTRST","Corporate-Trust"));
//		buList.add(new KeyValue("ASJPTK","Asset-Servicing"));
//		buList.add(new KeyValue("K01007","Broker-Dealer-Services"));
//		return buList;	
//	}
//	List<KeyValue> getSector() {
//		List<KeyValue> sectorList = new ArrayList<>();
//		sectorList.add(new KeyValue("",""));
//		sectorList.add(new KeyValue("",""));
//		sectorList.add(new KeyValue("",""));
//		sectorList.add(new KeyValue("",""));
//		sectorList.add(new KeyValue("",""));
//		sectorList.add(new KeyValue("",""));
//		sectorList.add(new KeyValue("",""));
//		return sectorList;
//	}

}
