package net.trigyan.glide.repository.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.manager.RemoteRepositoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.trigyan.glide.repository.model.RepositoryModel;

//@RestController
public class RepositoryAccessService {
	
	Logger logger = LoggerFactory.getLogger(RepositoryAccessService.class);
	public Collection<Repository> getRepositories() {
		//Add Rest calls
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<List<RepositoryModel>> responseBody = restTemplate.exchange("http://localhost:8080/rdf4j-server/repositories",
					//HttpMethod.GET,null,
					//new ParameterizedTypeReference<List<RepositoryModel>>() {});
		//String response = restTemplate.getForObject("http://localhost:8080/rdf4j-server/repositories", String.class);
		//return Arrays.asList(response);
		//logger.debug(response);
		//return null;
		String serverUrl = "http://localhost:8080/rdf4j-server";
		RemoteRepositoryManager manager = new RemoteRepositoryManager(serverUrl);
		manager.initialize();
		//manager.getAllRepositories();
		return manager.getAllRepositories();
		
	}
}
