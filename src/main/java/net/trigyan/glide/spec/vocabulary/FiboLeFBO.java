package net.trigyan.glide.spec.vocabulary;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * Formal Business Organizations Ontology.
 * <p>
 * Namespace FiboLeFBO.
 * Prefix: {@code <http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/>}
 *
 */
public class FiboLeFBO {

	/** {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/} **/
	public static final String NAMESPACE = "http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/";

	/** {@code fibolefbo} **/
	public static final String PREFIX = "fibo-be-le-fbo";

	/**
	 * branch
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/Branch}.
	 * <p>
	 * A part of a business organization or company, identified as a branch.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/Branch">Branch</a>
	 */
	public static final IRI Branch;

	/**
	 * division
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/Division}.
	 * <p>
	 * a part of a company, such as a line of business, that may have
	 * separate accounting or reporting requirements
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/Division">Division</a>
	 */
	public static final IRI Division;

	/**
	 * formally constituted organization
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/FormallyConstitutedOrganization}.
	 * <p>
	 * Any organization with some formal contractual agreement among its
	 * principals
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/FormallyConstitutedOrganization">FormallyConstitutedOrganization</a>
	 */
	public static final IRI FormallyConstitutedOrganization;

	/**
	 * formally constituted organization member
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/FormallyConstitutedOrganizationMember}.
	 * <p>
	 * A member of some formally constituted organization.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/FormallyConstitutedOrganizationMember">FormallyConstitutedOrganizationMember</a>
	 */
	public static final IRI FormallyConstitutedOrganizationMember;

	/**
	 * has equity
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasEquity}.
	 * <p>
	 * the formally constituted organization has some form of stockholders
	 * equity
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasEquity">hasEquity</a>
	 */
	public static final IRI hasEquity;

	/**
	 * has internal entity
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasInternalEntity}.
	 * <p>
	 * the organization has some part which is formally defined as an
	 * Internal Entity, for example for reporting, management or accounting
	 * purposes
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasInternalEntity">hasInternalEntity</a>
	 */
	public static final IRI hasInternalEntity;

	/**
	 * has operating address
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasOperatingAddress}.
	 * <p>
	 * address at which the organization carries out its operations
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasOperatingAddress">hasOperatingAddress</a>
	 */
	public static final IRI hasOperatingAddress;

	/**
	 * has primary address
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasPrimaryAddress}.
	 * <p>
	 * The main address at which communications to the organization may be
	 * addressed; its headquarters address.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasPrimaryAddress">hasPrimaryAddress</a>
	 */
	public static final IRI hasPrimaryAddress;

	/**
	 * has registered address
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasRegisteredAddress}.
	 * <p>
	 * The organization has an address at which it is registered and at which
	 * legal papers may be served on it.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasRegisteredAddress">hasRegisteredAddress</a>
	 */
	public static final IRI hasRegisteredAddress;

	/**
	 * has signatory
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasSignatory}.
	 * <p>
	 * has a party which is authorized to sign contracts on behalf of the
	 * entity
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasSignatory">hasSignatory</a>
	 */
	public static final IRI hasSignatory;

	/**
	 * has sub-unit
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasSubUnit}.
	 * <p>
	 * The company has a branch, which is part of that company. This may be
	 * in another country or in the country in which that company is
	 * registered (incorporated).
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/hasSubUnit">hasSubUnit</a>
	 */
	public static final IRI hasSubUnit;

	/**
	 * is sub-unit of
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/isSubUnitOf}.
	 * <p>
	 * The organization is a sub-unit of a formally constituted organization
	 * and has the role and function of being a formal part of that
	 * organization, such as a branch.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/isSubUnitOf">isSubUnitOf</a>
	 */
	public static final IRI isSubUnitOf;

	/**
	 * joint venture
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/JointVenture}.
	 * <p>
	 * A formal venture between two or more business entities
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/JointVenture">JointVenture</a>
	 */
	public static final IRI JointVenture;

	/**
	 * non-governmental organization
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/NonGovernmentalOrganization}.
	 * <p>
	 * a not for profit organization that is a citizen-based group that
	 * functions independently of government
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/NonGovernmentalOrganization">NonGovernmentalOrganization</a>
	 */
	public static final IRI NonGovernmentalOrganization;

	/**
	 * not for profit organization
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/NotForProfitOrganization}.
	 * <p>
	 * an organization that uses its surplus revenues to further achieve its
	 * purpose or mission, rather than distributing its surplus income to the
	 * organization's owners (directors, investors, or equivalents) as profit
	 * or dividends
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/NotForProfitOrganization">NotForProfitOrganization</a>
	 */
	public static final IRI NotForProfitOrganization;

	/**
	 * organizational sub-unit
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationalSubUnit}.
	 * <p>
	 * an organization that is part of a larger formal organization and only
	 * has full recognition within the context of that formal organization;
	 * In other words, it is not a legal entity in its own right.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationalSubUnit">OrganizationalSubUnit</a>
	 */
	public static final IRI OrganizationalSubUnit;

	/**
	 * organization covering agreement
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationCoveringAgreement}.
	 * <p>
	 * A formal agreement between the principals in a formal organization
	 * which covers the relationship between the principals, and between the
	 * principals and the entity.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationCoveringAgreement">OrganizationCoveringAgreement</a>
	 */
	public static final IRI OrganizationCoveringAgreement;

	/**
	 * organization identification scheme
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationIdentificationScheme}.
	 * <p>
	 * A formal scheme defining identification codes for a business entity.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationIdentificationScheme">OrganizationIdentificationScheme</a>
	 */
	public static final IRI OrganizationIdentificationScheme;

	/**
	 * organization identifier
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationIdentifier}.
	 * <p>
	 * A textual code which uniquely identifies a formal organization;
	 * Further Notes: Things which may identified by this kind of code
	 * Include but are not restricted to Legal Entity. At this most general
	 * level, this may be the identifier for a Fund, for a Legal Entity, for
	 * a Trust, or for the LEI scope of Artificial Person plus Trust.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationIdentifier">OrganizationIdentifier</a>
	 */
	public static final IRI OrganizationIdentifier;

	/**
	 * organization industry sector classification
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationIndustrySectorClassification}.
	 * <p>
	 * The classification of an organization in terms of the industry sector
	 * in which it carries out business.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/OrganizationIndustrySectorClassification">OrganizationIndustrySectorClassification</a>
	 */
	public static final IRI OrganizationIndustrySectorClassification;

	/**
	 * registered address
	 * <p>
	 * {@code http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/RegisteredAddress}.
	 * <p>
	 * The address at which an entity is registered and at which legal papers
	 * may be served.
	 *
	 * @see <a href="http://www.omg.org/spec/EDMC-FIBO/BE/LegalEntities/FormalBusinessOrganizations/RegisteredAddress">RegisteredAddress</a>
	 */
	public static final IRI RegisteredAddress;

	static {
		ValueFactory factory = SimpleValueFactory.getInstance();

		Branch = factory.createIRI(FiboLeFBO.NAMESPACE, "Branch");
		Division = factory.createIRI(FiboLeFBO.NAMESPACE, "Division");
		FormallyConstitutedOrganization = factory.createIRI(FiboLeFBO.NAMESPACE, "FormallyConstitutedOrganization");
		FormallyConstitutedOrganizationMember = factory.createIRI(FiboLeFBO.NAMESPACE, "FormallyConstitutedOrganizationMember");
		hasEquity = factory.createIRI(FiboLeFBO.NAMESPACE, "hasEquity");
		hasInternalEntity = factory.createIRI(FiboLeFBO.NAMESPACE, "hasInternalEntity");
		hasOperatingAddress = factory.createIRI(FiboLeFBO.NAMESPACE, "hasOperatingAddress");
		hasPrimaryAddress = factory.createIRI(FiboLeFBO.NAMESPACE, "hasPrimaryAddress");
		hasRegisteredAddress = factory.createIRI(FiboLeFBO.NAMESPACE, "hasRegisteredAddress");
		hasSignatory = factory.createIRI(FiboLeFBO.NAMESPACE, "hasSignatory");
		hasSubUnit = factory.createIRI(FiboLeFBO.NAMESPACE, "hasSubUnit");
		isSubUnitOf = factory.createIRI(FiboLeFBO.NAMESPACE, "isSubUnitOf");
		JointVenture = factory.createIRI(FiboLeFBO.NAMESPACE, "JointVenture");
		NonGovernmentalOrganization = factory.createIRI(FiboLeFBO.NAMESPACE, "NonGovernmentalOrganization");
		NotForProfitOrganization = factory.createIRI(FiboLeFBO.NAMESPACE, "NotForProfitOrganization");
		OrganizationalSubUnit = factory.createIRI(FiboLeFBO.NAMESPACE, "OrganizationalSubUnit");
		OrganizationCoveringAgreement = factory.createIRI(FiboLeFBO.NAMESPACE, "OrganizationCoveringAgreement");
		OrganizationIdentificationScheme = factory.createIRI(FiboLeFBO.NAMESPACE, "OrganizationIdentificationScheme");
		OrganizationIdentifier = factory.createIRI(FiboLeFBO.NAMESPACE, "OrganizationIdentifier");
		OrganizationIndustrySectorClassification = factory.createIRI(FiboLeFBO.NAMESPACE, "OrganizationIndustrySectorClassification");
		RegisteredAddress = factory.createIRI(FiboLeFBO.NAMESPACE, "RegisteredAddress");
	}

	private FiboLeFBO() {
		//static access only
	}

}
