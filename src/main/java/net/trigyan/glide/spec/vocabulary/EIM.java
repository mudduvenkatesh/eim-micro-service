package net.trigyan.glide.spec.vocabulary;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Namespace;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleNamespace;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

/**
 * Constants for EIM primitives and for the EIM namespace.<br>
 * Resources here are defined according to the EIM specs on
 * <a href=NAMESPACE+"/">NAMESPACE+"</a>, version 0.99
 */
public class EIM {
	/**
	 * The EIM Namespace
	 * The EIM Schema namepace: http://spec.trigyan.net/glide/EnterpriseInformationModel# 
	 */
	public static final String NAMESPACE = "http://spec.trigyan.net/glide/EnterpriseInformationModel#";
	/**
	 * The recommended prefix for the eim namespace: "eim"
	 */
	
	public final static String PREFIX = "eim";
	
	/**
	 * An immutable {@link Namespace} constant that represents the EIM namespace.
	 */
	public static final Namespace NS = new SimpleNamespace(PREFIX, NAMESPACE);
	
	public final static IRI ACCOUNTING_EVENT;
	public static final IRI ACCURACY;
	public static final IRI ANY_STANDARD_APPLICATION;
	public static final IRI BUSINESS_DATA;
	public static final IRI BUSINESS_RULE;
	public static final IRI BUSINESS_TERM;
	public static final IRI COMPLETENESS;
	public static final IRI CONFORMITY;
	public static final IRI CRITICAL_DATA_ELEMENT;
	public static final IRI DATA_ASSET;
	public static final IRI DATA_ATTRIBUTE;
	public static final IRI DATA_DOMAIN;
	public static final IRI DATA_ELEMENT;
	public static final IRI DATA_QUALITY_DIMENSION;
	public static final IRI DATA_QUALITY_RULE;
	public static final IRI DATASET;
	public static final IRI DERIVED_DATA;
	public static final IRI EVENT_DATA;
	public static final IRI FINANCIAL_EVENT;
	public static final IRI GOVERNANCE_ASSET;
	public static final IRI MASTER_DATA;
	public static final IRI REFERENCE_DATA;
	public static final IRI STANDARD_SERVICE;
	public static final IRI SOFTWARE_ASSET;
	public static final IRI TRANSACTION_DATA;
	public static final IRI VALIDITY;
	public static final IRI DATA_OWNER;
	public static final IRI DATA_STEWARD;
	public static final IRI DATA_CUSTODIAN;
	public static final IRI DATA_CLASSIFIED_BY;
	public static final IRI IS_AUTHORATATIVE_SOURCE_FOR;
	public static final IRI IS_DATA_PROVIDER_FOR;
	public static final IRI HAS_CODE;
	public static final IRI HAS_DESCRIPTION;
	public static final IRI HAS_DISPLAY_NAME;
	public static final IRI HAS_ID;
	public static final IRI HAS_NAME;
	public static final IRI IS_GOVERNED_BY;
	public static final IRI IS_PROVISIONED_BY;
	public static final IRI IS_MANAGED_BY;
	public static final IRI DATA_VISIBIITY_CLASSIFICATION;
	public static  final IRI PUBLIC;
	public static final IRI INTERNAL;
	public static final IRI CONFIDENTIAL;
	public static final IRI HCI;
	public static final IRI PID;
	public static final IRI CID;
	public static final IRI ASSET_ID;
	public static final IRI ASSET_NAME;
	public static final IRI IS_OWNED_BY;
	public static final IRI APPLICATION_ID;
	public static final IRI APPLICATION_NAME;
	public static final IRI SERVICE_NAME;
	public static final IRI SERVICE_ID;
	public static final IRI HAS_DEFINITION;
	
	 
	static {
		ValueFactory factory = SimpleValueFactory.getInstance();
		ACCOUNTING_EVENT = factory.createIRI(NAMESPACE+"AccountingEvent");
		ACCURACY=factory.createIRI(NAMESPACE+"Accuracy");
		ANY_STANDARD_APPLICATION=factory.createIRI(NAMESPACE+"Application");
		BUSINESS_DATA=factory.createIRI(NAMESPACE+"BusinessData");
		BUSINESS_RULE=factory.createIRI(NAMESPACE+"BusinessRule");
		BUSINESS_TERM=factory.createIRI(NAMESPACE+"BusinessTerm");
		GOVERNANCE_ASSET=factory.createIRI(NAMESPACE+"GovernanceAsset");
		MASTER_DATA=factory.createIRI(NAMESPACE+"MasterData");
		REFERENCE_DATA=factory.createIRI(NAMESPACE+"ReferenceData");
		STANDARD_SERVICE=factory.createIRI(NAMESPACE+"Service");
		SOFTWARE_ASSET=factory.createIRI(NAMESPACE+"SoftwareAsset");
		TRANSACTION_DATA=factory.createIRI(NAMESPACE+"TransactionData");
		COMPLETENESS=factory.createIRI(NAMESPACE+"Completeness");
		CONFORMITY=factory.createIRI(NAMESPACE+"Conformity");
		CRITICAL_DATA_ELEMENT=factory.createIRI(NAMESPACE+"CriticalDataElement");
		DATASET=factory.createIRI(NAMESPACE+"Dataset");
		DERIVED_DATA=factory.createIRI(NAMESPACE+"DerivedData");
		DATA_ASSET=factory.createIRI(NAMESPACE+"DataAsset");
		DATA_ATTRIBUTE=factory.createIRI(NAMESPACE+"DataAttribute");
		DATA_DOMAIN=factory.createIRI(NAMESPACE+"DataDomain");
		DATA_ELEMENT=factory.createIRI(NAMESPACE+"DataElement");
		DATA_QUALITY_DIMENSION=factory.createIRI(NAMESPACE+"DataQualityDimension");
		DATA_QUALITY_RULE=factory.createIRI(NAMESPACE+"DataQualityRule");
		EVENT_DATA=factory.createIRI(NAMESPACE+"EventData");
		FINANCIAL_EVENT=factory.createIRI(NAMESPACE+"FinancialEvent");
		VALIDITY=factory.createIRI(NAMESPACE+"Validity");
		DATA_OWNER = factory.createIRI(NAMESPACE+"DataOwner");
		DATA_CUSTODIAN=factory.createIRI(NAMESPACE+"DataCustodian");
		DATA_STEWARD=factory.createIRI(NAMESPACE+"DataSteward");
		DATA_CLASSIFIED_BY = factory.createIRI(NAMESPACE+"data_classified_by");
		//HAS_DATA_CUSTODIAN = factory.createIRI(NAMESPACE+"#has_data_custodian");
		//HAS_DATA_OWNER = factory.createIRI(NAMESPACE+"#has_data_owner");
		//HAS_DATA_STEWARD = factory.createIRI(NAMESPACE+"#has_data_steward");
		IS_AUTHORATATIVE_SOURCE_FOR = factory.createIRI(NAMESPACE+"is_authoratative_source_for");
		IS_DATA_PROVIDER_FOR = factory.createIRI(NAMESPACE+"is_data_provider_for");
		IS_GOVERNED_BY = factory.createIRI(NAMESPACE+"is_governed_by");
		IS_MANAGED_BY = factory.createIRI(NAMESPACE+"#is_managed_by");
		IS_PROVISIONED_BY=factory.createIRI(NAMESPACE+"is_provisioned_by");
		HAS_CODE = factory.createIRI(NAMESPACE+"hasCode");
		HAS_DESCRIPTION = factory.createIRI(NAMESPACE+"hasDescription");
		HAS_DISPLAY_NAME = factory.createIRI(NAMESPACE+"hasDisplayName");
		HAS_ID = factory.createIRI(NAMESPACE+"hasId");
		HAS_NAME = factory.createIRI(NAMESPACE+"hasName");
		DATA_VISIBIITY_CLASSIFICATION = factory.createIRI(NAMESPACE+"DataVisibiityClassification");
		PUBLIC = factory.createIRI(NAMESPACE+"Public");
		INTERNAL=factory.createIRI(NAMESPACE+"Internal");
		CONFIDENTIAL=factory.createIRI(NAMESPACE+"Confidential");
		HCI = factory.createIRI(NAMESPACE+"HCI");
		PID = factory.createIRI(NAMESPACE+"PID");
		CID = factory.createIRI(NAMESPACE+"CID");
		ASSET_ID = factory.createIRI(NAMESPACE + "asset_id");
		ASSET_NAME = factory.createIRI(NAMESPACE+"asset_name");
		IS_OWNED_BY=factory.createIRI(NAMESPACE+"is_owned_by");
		APPLICATION_ID=factory.createIRI(NAMESPACE+"applicationId");;
		APPLICATION_NAME=factory.createIRI(NAMESPACE+"applicationName");
		SERVICE_NAME=factory.createIRI(NAMESPACE+"serviceName");
		SERVICE_ID=factory.createIRI(NAMESPACE+"serviceId");
		HAS_DEFINITION=factory.createIRI(NAMESPACE+"hasDefinition");
		
	}
	
}
