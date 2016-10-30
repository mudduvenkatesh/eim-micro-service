package net.trigyan.glide;

import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.trigyan.glide.Dao.OrganizationDAO;
import net.trigyan.glide.model.EIMModelFactory;
import net.trigyan.glide.model.SimpleEIMModelFactory;
import net.trigyan.glide.spec.vocabulary.DefaultIRIMintingService;
import net.trigyan.glide.spec.vocabulary.IRIMintingService;

@Configuration
public class EIMAppConfiguration {
	@Value("${glide.eim.graphdb.server.url}")
	String graphDBServer;
	@Value("${glide.eim.graphdb.repository}")
	String repositoryId;
	
	@Bean
	public Repository graphDBRepository() {
		Repository repo = new HTTPRepository(graphDBServer, repositoryId);
		repo.initialize();
		return repo;
	}
	@Bean
	public ValueFactory valueFactory() {
		ValueFactory f = graphDBRepository().getValueFactory();
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
	
	
	
	
	
	
}
