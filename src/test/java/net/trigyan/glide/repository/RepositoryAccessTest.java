package net.trigyan.glide.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.trigyan.glide.repository.service.RepositoryAccessService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryAccessTest {

	
	@Autowired
	RepositoryAccessService repositoryAccessService;
	
	Logger logger = LoggerFactory.getLogger(RepositoryAccessTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNotNullRepositoryService() {
		assertThat(repositoryAccessService, is(not(equalTo(null))));
	}
	@Test
	public void testGetRepositories() {
		assertThat(repositoryAccessService.getRepositories(),is(not(equalTo(null))));
	}
}
