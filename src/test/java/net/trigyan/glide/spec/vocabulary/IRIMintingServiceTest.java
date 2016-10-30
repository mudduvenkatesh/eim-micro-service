package net.trigyan.glide.spec.vocabulary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

public class IRIMintingServiceTest {

//	@Test
//	public void testSlashIRI() {
//		SimpleValueFactory vf = SimpleValueFactory.getInstance();		
//		String base ="http://spec.mycompany.net";
//		UUID id = UUID.randomUUID();
//		String fragment="Application";
//		IRI expected=vf.createIRI(String.format("%s/%s/%s/%s", base,fragment,id));
//		System.out.println(expected);
//		IRIMintingService minter = mock(DefaultIRIMintingService.class);
//		Concept c = new DefaultConcept("App", "Application");
//		when(minter.mintHashIRI(base, c)).thenReturn(expected);
//		//call the actual function
//		IRI actual = minter.mintHashIRI(base, c);
//		assertEquals(expected, actual);
//	}
//	@Test
//	public void testSlashUriWithIdentifier() {
//		SimpleValueFactory vf = SimpleValueFactory.getInstance();		
//		String base ="http://spec.mycompany.net";
//		String id = "myCompany";
//		String fragment="Organization";
//		IRI expected=vf.createIRI(String.format("%s/%s/%s", base,fragment,id));
//		System.out.println(expected);
//		IRIMintingService minter = mock(DefaultIRIMintingService.class);
//		Concept c = new DefaultConcept("App", "Application");
//		when(minter.mintHashIRI(base, c,id)).thenReturn(expected);
//		//call the actual function
//		IRI actual = minter.mintHashIRI(base, c,id);
//		assertEquals(expected, actual);
//	}
//	@Test
//	public void testSlashUriWithIdentifier2() {
//		SimpleValueFactory vf = SimpleValueFactory.getInstance();		
//		String base ="http://spec.mycompany.net";
//		String id = "myCompany";
//		IRIMintingService minter = new DefaultIRIMintingService();
//		Concept c = new DefaultConcept("Org", "Organization");
//		IRI expected=vf.createIRI(String.format("%s/%s/%s/%s", base,c.getType(),c.getFragment(),id));
//		//call the actual function
//		IRI actual = minter.mintSlashIRI(base, c,id);
//		assertEquals(expected, actual);
//	}
//	@Test
//	public void testHashUriWithIdentifier2() {
//		SimpleValueFactory vf = SimpleValueFactory.getInstance();		
//		String base ="http://spec.mycompany.net";
//		String id = "myCompany";
//		IRIMintingService minter = new DefaultIRIMintingService();
//		Concept c = new DefaultConcept("Org", "MyOrg");
//		IRI expected=vf.createIRI(String.format("%s/%s/%s#%s", base,c.getType(),c.getFragment(),id));
//		//call the actual function
//		IRI actual = minter.mintHashIRI(base, c,id);
//		assertEquals(expected, actual);
//	}

}
