package net.trigyan.glide.server;

import static org.junit.Assert.*;

import java.util.Collection;

import org.eclipse.rdf4j.repository.manager.RemoteRepositoryManager;
import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoteRepositoryOperationTest {

	Logger logger = LoggerFactory.getLogger(RepositoryConnectionTest.class);
	@Value("${glide.eim.graphdb.server.url}")
	String repo;
	
	
	@Test
	public void testRemoteRepoConnection() {
		RemoteRepositoryManager manager = new RemoteRepositoryManager(repo);
		manager.initialize();
		Collection<RepositoryInfo> repos = manager.getAllRepositoryInfos();
		//repos.stream().map(r->r.getId())	
	}

}
