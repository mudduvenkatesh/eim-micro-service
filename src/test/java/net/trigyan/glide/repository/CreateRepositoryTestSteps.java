package net.trigyan.glide.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.rdf4j.model.Namespace;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;
import net.trigyan.glide.EIMAppConfiguration;
import net.trigyan.glide.EimMicroServiceApplication;
import net.trigyan.glide.repository.service.RepositoryAccessService;
import net.trigyan.glide.repository.service.SpringIntegrationTest;

//@RunWith(Cucumber.class)
//@CucumberOptions(features="classpath:features")
//@ContextConfiguration(classes = EimMicroServiceApplication.class, loader = SpringBootContextLoader.class)
public class CreateRepositoryTestSteps extends SpringIntegrationTest implements En  {

	@Autowired
	RepositoryAccessService repositoryAccessService;
	@Autowired
	RepositoryManager remoteRepositoryManager;
	@cucumber.api.java.Before
	public void before() {
	}
	public CreateRepositoryTestSteps() {
		Given("^I have the RepositoryAccessService setup$",()-> {
			assertNotNull(repositoryAccessService);
			assertNotNull(remoteRepositoryManager);
		});
		When("^I call createRepository with id \"([^\"]*)\" and \"([^\"]*)\"$", (String id, String title)->{
				boolean exists = repositoryAccessService
						.getRepositories()
						.stream()
						.anyMatch(repo->repo.getId().equals(id));
				if(exists) {
					repositoryAccessService.dropRepository(id);
				}
				repositoryAccessService.createRepository(id, title);
			});
		Then("^there should be alteast (\\d+) repositories and the one of them should be \"([^\"]*)\"$",
				(Integer noOfRepos,String id)->{
			Collection<RepositoryInfo> repos = repositoryAccessService.getRepositories();
			assertThat(repos,is(not(equalTo(null))));
			assertThat(repos.size(),is(equalTo(2)));
			Optional<RepositoryInfo> testRepo = repos.stream().filter(repo->repo.getId().equals(id)).findFirst();
			assertThat(testRepo,is(not(equalTo(null))));	
			Repository repo = remoteRepositoryManager.getRepository(id);
			try(RepositoryConnection conn = repo.getConnection()) {
				List<Namespace> repoNamespaceList = conn.getNamespaces().asList();
				Optional<Namespace> rdfsNs = repoNamespaceList.stream().filter(ns->ns.getPrefix().equals(RDFS.PREFIX)).findFirst();
				assertThat(rdfsNs,is(not(equalTo(null))));
				conn.close();
			} catch(Exception e) {
				
			}finally {
				
			}
			
			
		});
	}
}
