package net.trigyan.glide.spec.vocabulary;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * Organizations Ontology.
 * <p>
 * Namespace FiboOrgaizations.
 * Prefix: {@code <http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/>}
 *
 */
public class FiboOrganizations {

	/** {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/} **/
	public static final String NAMESPACE = "http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/";

	/** {@code fiboorgaizations} **/
	public static final String PREFIX = "fibo-fnd-org-org";

	/**
	 * organization
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/Organization}.
	 * <p>
	 * a social unit of people, systematically structured and managed to meet
	 * a need or pursue collective goals on a continuing basis
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/Organizations/Organization">Organization</a>
	 */
	public static final IRI Organization;

	static {
		ValueFactory factory = SimpleValueFactory.getInstance();

		Organization = factory.createIRI(FiboOrganizations.NAMESPACE, "Organization");
	}

	private FiboOrganizations() {
		//static access only
	}

}
