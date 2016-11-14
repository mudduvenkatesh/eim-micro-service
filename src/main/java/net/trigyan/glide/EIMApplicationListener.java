package net.trigyan.glide;

import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import net.trigyan.glide.repository.service.RepositoryAccessService;

@Component
public class EIMApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	RepositoryAccessService repositoryAccessService;
	@Value("${glide.eim.repository.repo-id}")
	String repositoryId;
	@Value("${glide.eim.repository.repo-name}")
	String repositoryName;

	Logger logger = LoggerFactory.getLogger(EIMApplicationListener.class);
	String baseIRI = "http://spec.myenterprisecompany.net";
	@Override
	public void onApplicationEvent(ApplicationReadyEvent appReadyEvent) {
		logger.info("EIM App started");
		// Check for existance of the repo defined in the YML File
		RepositoryInfo repInfo = repositoryAccessService.getRepository(repositoryId);
		if (repInfo == null) {
			// No repo exists
			// Create one
			//logger.info("No Repository exists in the RDF backend server with id " + repositoryId);
			RepositoryInfo newRepInfo = repositoryAccessService.createBootStrapRepository(
					baseIRI);
			logger.info(String.format("Created Repo %s[%s] in %s", newRepInfo.getId(), newRepInfo.getDescription(),
					newRepInfo.getLocation()));

		} else {
			logger.info(String.format("RDF Repo %s[%s] in %s", repInfo.getId(), repInfo.getDescription(),
					repInfo.getLocation()));
		}

	}

}
