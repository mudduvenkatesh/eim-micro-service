package net.trigyan.glide;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.eclipse.rdf4j.repository.manager.RepositoryProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import net.trigyan.glide.eim.Dao.ConfigurationDao;
import net.trigyan.glide.model.EIMModelFactory;
import net.trigyan.glide.model.SimpleEIMModelFactory;
import net.trigyan.glide.repository.service.RepositoryAccessService;
import net.trigyan.glide.spec.vocabulary.DefaultIRIMintingService;
import net.trigyan.glide.spec.vocabulary.EIM;
import net.trigyan.glide.spec.vocabulary.IRIMintingService;

@Configuration
public class EIMAppConfiguration {
	@Value("${graphdb.server.url}")
	String graphDBServer;
	@Value("${glide.eim.repository.repo-id}")
	String repositoryId;
	@Value("${glide.eim.repository.eim-config-graph-context}")
	String eimGraphContextName;
	
	
	
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
//	@Bean
//	public Repository graphDBRepository() {
//		Repository repo = new HTTPRepository(graphDBServer, repositoryId);
//		repo.initialize();
//		return repo;
//	}
	@Bean
	public ValueFactory valueFactory() {
		ValueFactory f = SimpleValueFactory.getInstance();
		return f;
	}
	@Bean
	public IRIMintingService iriMintingService() {
		return new DefaultIRIMintingService();
	}
	
	@Bean
	public EIMModelFactory modelFactory() {
		return new SimpleEIMModelFactory();
	}
	
	@Bean 
	public RepositoryAccessService repositoryAccessService() {
		return new RepositoryAccessService();
	}
	@Bean
	public RepositoryManager remoteRepositoryManager() {
		//RemoteRepositoryManager manager = new RemoteRepositoryManager(graphDBServer);
		RepositoryManager manager = RepositoryProvider.getRepositoryManager(graphDBServer);
		manager.initialize();
		return manager;
	}
	@Bean(name={"eim-config","eim-configuration"})
	public IRI eimConfiguratonContext() {
		IRI contextName = valueFactory().createIRI(EIM.PREFIX+":"+eimGraphContextName);
		return contextName;
	}
	
	@Bean
	public ConfigurationDao configurationDao() {
		return new ConfigurationDao();
	}
	
	
	
	
	
	
	
}
