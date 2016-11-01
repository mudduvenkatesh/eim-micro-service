package net.trigyan.glide.repository.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.config.RepositoryConfig;
import org.eclipse.rdf4j.repository.manager.RemoteRepositoryManager;
import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.trigyan.glide.repository.model.RepositoryModel;

@RestController
public class RepositoryAccessService {
	
	@Autowired
	RepositoryManager manager;
	Logger logger = LoggerFactory.getLogger(RepositoryAccessService.class);
	@RequestMapping("/repositories")
	public Collection<RepositoryInfo> getRepositories() {
		return manager.getAllRepositoryInfos();		
		
	}
	
}
