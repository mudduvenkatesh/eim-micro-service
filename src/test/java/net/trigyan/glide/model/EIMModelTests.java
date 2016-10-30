package net.trigyan.glide.model;

import static org.junit.Assert.*;

import org.eclipse.rdf4j.model.IRI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.trigyan.glide.spec.vocabulary.Concept;
import net.trigyan.glide.spec.vocabulary.DefaultConcept;
import net.trigyan.glide.spec.vocabulary.IRIMintingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EIMModelTests {

	private final Logger logger = LoggerFactory.getLogger(EIMModelTests.class);
	@Autowired
	IRIMintingService iriMintingService;
	@Autowired
	EIMModelFactory modelFactory;
	@Test
	public void test() {
		String base = "http://spec.myorg.net";
		Concept c = new DefaultConcept("Organization");
		IRI org1 = iriMintingService.mintHashIRI(base, c, "MyEnterpriseBank");
		logger.info(org1.stringValue());
	}
	@Test
	public void testCreateOrganization() {
		String base = "http://spec.myorg.net";
		Organization org = modelFactory.createOrganization(base, "MyEnterpriseBank", "MyEnterprise Bank",
				"My Enterprise Bank");
		logger.info(org.toString());
	}
	

}
