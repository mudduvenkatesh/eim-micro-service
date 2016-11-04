package net.trigyan.glide.server;

import static org.junit.Assert.*;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RepositoryConnectionTest {

//	@Value("${glide.eim.graphdb.server.url}")   
//	String repositoryServerUrl;
//	@Value("${glide.eim.graphdb.repository}")
//	String repositoryId;
//	
//	private final Logger logger = LoggerFactory.getLogger(RepositoryConnectionTest.class);
//	@Test
//	public void testRepoConnection() {
//		Repository repo = new HTTPRepository(repositoryServerUrl, repositoryId);
//		repo.initialize();
//		logger.info(String.format("Repository Initialized(%s),Writable(%s),Connection(%s)",repo.isInitialized(),repo.isWritable(),
//				repo.getConnection().isOpen()));
//		repo.getConnection().close();
//	}

}
