package net.trigyan.glide.spec.vocabulary;
import org.eclipse.rdf4j.*;
//import org.openrdf.model.ValueFactory;
//import org.openrdf.model.impl.ValueFactoryImpl;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * Agents Ontology.
 * <p>
 * Namespace FiboAgents.
 * Prefix: {@code <http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/>}
 *
 */
public class FiboAgents {

	/** {@code http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/} **/
	public static final String NAMESPACE = "http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/";

	/** {@code fiboagents} **/
	public static final String PREFIX = "fibo-fnd-aap-agt";

	/**
	 * autonomous agent
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/AutonomousAgent}.
	 * <p>
	 * An agent is an autonomous individual that can adapt to and interact
	 * with its environment.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/AutonomousAgent">AutonomousAgent</a>
	 */
	public static final IRI AutonomousAgent;

	/**
	 * has name
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/hasName}.
	 * <p>
	 * that by which some thing is known; may apply to anything
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/hasName">hasName</a>
	 */
	public static final IRI hasName;

	/**
	 * identifies
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/identifies}.
	 * <p>
	 * is the relationship between something and that which provides a unique
	 * reference for it
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/identifies">identifies</a>
	 */
	public static final IRI identifies;

	/**
	 * is identified by
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/isIdentifiedBy}.
	 * <p>
	 * provides a unique identifier for something
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/FND/AgentsAndPeople/Agents/isIdentifiedBy">isIdentifiedBy</a>
	 */
	public static final IRI isIdentifiedBy;

	static {
		ValueFactory factory = SimpleValueFactory.getInstance();

		AutonomousAgent = factory.createIRI(FiboAgents.NAMESPACE, "AutonomousAgent");
		hasName = factory.createIRI(FiboAgents.NAMESPACE, "hasName");
		identifies = factory.createIRI(FiboAgents.NAMESPACE, "identifies");
		isIdentifiedBy = factory.createIRI(FiboAgents.NAMESPACE, "isIdentifiedBy");
	}

	private FiboAgents() {
		//static access only
	}

}
