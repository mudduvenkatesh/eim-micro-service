package net.trigyan.glide.spec.vocabulary;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * Formal Organizations Ontology.
 * <p>
 * Namespace FiboFormalOrganizations.
 * Prefix: {@code <http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/>}
 *
 */
public class FiboFormalOrganizations {

	/** {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/} **/
	public static final String NAMESPACE = "http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/";

	/** {@code fiboformalorganizations} **/
	public static final String PREFIX = "fibo-fnd-org-fm";

	/**
	 * formal organization
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/FormalOrganization}.
	 * <p>
	 * an organization that is recognized in some legal jurisdiction, with
	 * associated rights and responsibilities
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/FormalOrganization">FormalOrganization</a>
	 */
	public static final IRI FormalOrganization;

	/**
	 * group
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/Group}.
	 * <p>
	 * a collection of autonomous entities
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/Group">Group</a>
	 */
	public static final IRI Group;

	/**
	 * informal organization
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/InformalOrganization}.
	 * <p>
	 * An organization which is not formally constituted in some way.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/InformalOrganization">InformalOrganization</a>
	 */
	public static final IRI InformalOrganization;

	/**
	 * is domiciled in
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/isDomiciledIn}.
	 * <p>
	 * identifies the permanent home or principal establishment of an
	 * individual or organization
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/Organizations/FormalOrganizations/isDomiciledIn">isDomiciledIn</a>
	 */
	public static final IRI isDomiciledIn;

	static {
		ValueFactory factory = SimpleValueFactory.getInstance();

		FormalOrganization = factory.createIRI(FiboFormalOrganizations.NAMESPACE, "FormalOrganization");
		Group = factory.createIRI(FiboFormalOrganizations.NAMESPACE, "Group");
		InformalOrganization = factory.createIRI(FiboFormalOrganizations.NAMESPACE, "InformalOrganization");
		isDomiciledIn = factory.createIRI(FiboFormalOrganizations.NAMESPACE, "isDomiciledIn");
	}

	private FiboFormalOrganizations() {
		//static access only
	}

}
