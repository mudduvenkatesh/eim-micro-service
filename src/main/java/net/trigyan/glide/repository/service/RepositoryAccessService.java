package net.trigyan.glide.repository.service;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.rdf4j.RDF4JException;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.config.RepositoryConfig;
import org.eclipse.rdf4j.repository.config.RepositoryImplConfig;
import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.eclipse.rdf4j.repository.sail.config.SailRepositoryConfig;
import org.eclipse.rdf4j.sail.config.SailImplConfig;
import org.eclipse.rdf4j.sail.memory.config.MemoryStoreConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.trigyan.glide.spec.vocabulary.FiboAgents;
import net.trigyan.glide.spec.vocabulary.FiboFormalOrganizations;
import net.trigyan.glide.spec.vocabulary.FiboLeFBO;
import net.trigyan.glide.spec.vocabulary.FiboOrganizations;

@RestController
public class RepositoryAccessService {
	
	@Autowired
	RepositoryManager manager;
	
	Logger logger = LoggerFactory.getLogger(RepositoryAccessService.class);
	@RequestMapping("/repositories")
	public Collection<RepositoryInfo> getRepositories() {
		return manager.getAllRepositoryInfos();			
		
	}
	@RequestMapping(value="/createRepository",method=RequestMethod.POST)
	public @ResponseBody RepositoryInfo createRepository(@RequestParam("id") String id,
			@RequestParam("name") String name) {
		RepositoryConfig config = new RepositoryConfig(id, name);
		//ForwardChainingRDFSInferencerConfig impl = new ForwardChainingRDFSInferencerConfig();
		boolean persist = true;
		SailImplConfig backendConfig = new MemoryStoreConfig(persist);
		RepositoryImplConfig repositoryTypeSpec = new SailRepositoryConfig(backendConfig);
		config.setRepositoryImplConfig(repositoryTypeSpec);
		manager.addRepositoryConfig(config);
		//Add NameSpaces - Must move to Config
		//model.setNamespace("rdf", RDF.NAMESPACE);
		//model.setNamespace("rdfs", RDFS.NAMESPACE);
		Repository repo = manager.getRepository(id);
		try (RepositoryConnection conn = repo.getConnection()) {
			conn.setNamespace(RDF.PREFIX, RDF.NAMESPACE);
			conn.setNamespace(RDFS.PREFIX, RDFS.NAMESPACE);
			conn.setNamespace(FiboAgents.PREFIX, FiboAgents.NAMESPACE);
			conn.setNamespace(FiboOrganizations.PREFIX, FiboOrganizations.NAMESPACE);
			conn.setNamespace(FiboLeFBO.PREFIX, FiboLeFBO.NAMESPACE);
			conn.setNamespace(FiboFormalOrganizations.PREFIX, FiboFormalOrganizations.NAMESPACE);						
			conn.close();	
			return manager.getRepositoryInfo(id);
		} catch (RDF4JException e) {
			
		}finally {
			
		}
		return null;
		
	}
	@RequestMapping(value="/dropRepository/{id}",method=RequestMethod.POST)
	public void dropRepository(@PathVariable("id") String id) {
		RepositoryInfo repo = manager.getRepositoryInfo(id);
		if(repo!=null) {
			manager.removeRepository(id);
		} else {
			logger.info("No repository found for " + id); 
		}
		
	}
	@RequestMapping(value="/repositories/{id}",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody RepositoryInfo getRepository(@PathVariable String id) {
		logger.info("Getting Repo Info for : " + id);
		RepositoryInfo repo = manager.getRepositoryInfo(id);
		if(repo==null) logger.info("No Repository exists in the RDF backend server with id " + id); 
		return repo;
	}
	/**
	 * Only called from Boot App, hence no rest uri
	 * @param id
	 * @param name
	 * @param baseUri
	 */
	public void createBootStrapRepository(String baseUri) {
		
	}
	
}
