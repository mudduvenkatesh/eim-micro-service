package net.trigyan.glide.repository.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.rdf4j.RDF4JException;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.config.RepositoryConfig;
import org.eclipse.rdf4j.repository.config.RepositoryImplConfig;
import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.eclipse.rdf4j.repository.sail.config.SailRepositoryConfig;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.sail.config.SailImplConfig;
import org.eclipse.rdf4j.sail.memory.config.MemoryStoreConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.trigyan.glide.repository.model.Configuration;
import net.trigyan.glide.spec.vocabulary.EIM;
import net.trigyan.glide.spec.vocabulary.FiboAgents;
import net.trigyan.glide.spec.vocabulary.FiboFormalOrganizations;
import net.trigyan.glide.spec.vocabulary.FiboLeFBO;
import net.trigyan.glide.spec.vocabulary.FiboOrganizations;

@RestController
public class RepositoryAccessService {

	@Autowired
	RepositoryManager manager;
	@Value("${glide.eim.repository.repo-id}")
	String eimRepositoryId;
	@Value("${glide.eim.repository.repo-name}")
	String eimRepositoryName;
	// Moved to EIMAppConfiguration
	// @Value("${glide.eim.repository.eim-config-graph-context}")
	// String eimGraphContextName;
	@Autowired
	@Qualifier("eim-config")
	IRI eimConfiguratonContext;
	@Autowired
	ValueFactory valueFactory;

	Logger logger = LoggerFactory.getLogger(RepositoryAccessService.class);

	@Autowired
	private ResourceLoader resourceLoader;

	@RequestMapping("/repositories")
	public Collection<RepositoryInfo> getRepositories() {
		return manager.getAllRepositoryInfos();

	}

	@RequestMapping(value = "/createRepository", method = RequestMethod.POST)
	public @ResponseBody RepositoryInfo createRepository(@RequestParam("id") String id,
			@RequestParam("name") String name) {
		RepositoryConfig config = new RepositoryConfig(id, name);
		// ForwardChainingRDFSInferencerConfig impl = new
		// ForwardChainingRDFSInferencerConfig();
		boolean persist = true;
		SailImplConfig backendConfig = new MemoryStoreConfig(persist);
		RepositoryImplConfig repositoryTypeSpec = new SailRepositoryConfig(backendConfig);
		config.setRepositoryImplConfig(repositoryTypeSpec);
		manager.addRepositoryConfig(config);
		// Add NameSpaces - Must move to Config
		// model.setNamespace("rdf", RDF.NAMESPACE);
		// model.setNamespace("rdfs", RDFS.NAMESPACE);
		Repository repo = manager.getRepository(id);
		try (RepositoryConnection conn = repo.getConnection()) {
			conn.setNamespace(RDF.PREFIX, RDF.NAMESPACE);
			conn.setNamespace(RDFS.PREFIX, RDFS.NAMESPACE);
			conn.setNamespace(FiboAgents.PREFIX, FiboAgents.NAMESPACE);
			conn.setNamespace(FiboOrganizations.PREFIX, FiboOrganizations.NAMESPACE);
			conn.setNamespace(FiboLeFBO.PREFIX, FiboLeFBO.NAMESPACE);
			conn.setNamespace(FiboFormalOrganizations.PREFIX, FiboFormalOrganizations.NAMESPACE);
			//conn.setNamespace(EIM.PREFIX, EIM.NAMESPACE);
			conn.close();
			return manager.getRepositoryInfo(id);
		} catch (RDF4JException e) {

		} finally {

		}
		return null;

	}

	@RequestMapping(value = "/dropRepository/{id}", method = RequestMethod.POST)
	public void dropRepository(@PathVariable("id") String id) {
		RepositoryInfo repo = manager.getRepositoryInfo(id);
		if (repo != null) {
			manager.removeRepository(id);
		} else {
			logger.info("No repository found for " + id);
		}

	}

	@RequestMapping(value = "/repositories/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RepositoryInfo getRepository(@PathVariable String id) {
		logger.info("Getting Repo Info for : " + id);
		RepositoryInfo repo = manager.getRepositoryInfo(id);
		if (repo == null)
			logger.info("No Repository exists in the RDF backend server with id " + id);
		return repo;
	}

	/**
	 * Only called from Boot App, hence no rest uri
	 * 
	 * @param id
	 * @param name
	 * @param baseUri
	 * @return
	 */
	public RepositoryInfo createBootStrapRepository(String baseUri) {
		// IRI contextName =
		// valueFactory.createIRI(EIM.PREFIX+":"+eimGraphContextName);
		
		this.createRepository(eimRepositoryId, eimRepositoryName);
		// connect to the repository
		Resource eimResource = resourceLoader.getResource("classpath:EnterpriseInformationModel.rdf");
		
		Repository eimrepo = manager.getRepository(eimRepositoryId);

		// create a RDF model to persist config properties
		// Properties that are required for EIM operation
		// 1. BaseURI
		// Store in a context called eim-config-v1 (Defined in application.yml)
		Model m = buildEIMBootStrapConfig(baseUri, eimConfiguratonContext);
		try {
			RepositoryConnection conn = eimrepo.getConnection();
			File eimRDFFile = eimResource.getFile();
			conn.add(eimRDFFile, EIM.NAMESPACE, RDFFormat.RDFXML);
			m.stream().forEach(stmt -> {
				conn.add(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), eimConfiguratonContext);
			});
			conn.close();
		} catch (RDF4JException e) {
			// TODO: Add Error Handling
			e.printStackTrace();
			// TODO: remove the repository also
		} catch(IOException e) {
			e.printStackTrace();
		} finally {

		}
		return manager.getRepositoryInfo(eimRepositoryId);

	}

	protected Model buildEIMBootStrapConfig(String baseIRI, IRI contextName) {
		ModelBuilder builder = new ModelBuilder();
		IRI config = valueFactory.createIRI(EIM.PREFIX + ":eim-app-config");
		IRI baseIRIProperty = valueFactory.createIRI(EIM.PREFIX + ":" + "baseIRIConfigProperty");
		builder.setNamespace(EIM.PREFIX, EIM.NAMESPACE);
		builder.namedGraph(contextName).subject(config).add(RDF.TYPE, EIM.EIMApplicationCONFIGURATION)
				.add(RDFS.LABEL, "EIM Base Application Configuration").subject(baseIRIProperty)
				.add(RDF.TYPE, EIM.EIM_CONFIG_PROPERTY).add(RDFS.LABEL, "Base IRI used for all instances/individuals for this app")
				.add(EIM.CONFIG_PROPERTY_NAME, Configuration.baseIRIPropertyName)
				.add(EIM.CONFIG_PROPERTY_VALUE, baseIRI).subject(config).add(EIM.hasConfigProperty, baseIRIProperty);
		// .add
		return builder.build();
	}

}
