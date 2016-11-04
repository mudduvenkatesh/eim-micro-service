package net.trigyan.glide.repository;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.springframework.beans.factory.annotation.Autowired;


import cucumber.api.java8.En;
import net.trigyan.glide.repository.service.RepositoryAccessService;
import net.trigyan.glide.repository.service.SpringIntegrationTest;

//@SpringBootTest
//@ContextConfiguration(classes= EIMAppConfiguration.class)
//@ContextConfiguration(classes = EIMAppConfiguration.class, loader = SpringBootContextLoader.class)
public class RepositoryAccessTestSteps extends SpringIntegrationTest implements En {
	
	@Autowired
	RepositoryAccessService repositoryAccessService;
	
	@cucumber.api.java.Before
	public void before() {
		//repositoryAccessService=new RepositoryAccessService();
	}
	
	private Collection<RepositoryInfo> repos = null;
	
	public RepositoryAccessTestSteps() {
		Given("^I have the RepositoryAccessService$",()-> {
			assertNotNull(repositoryAccessService);
		});
		
		When("^I call getRepositories$",()->{
			repos = repositoryAccessService.getRepositories();
			assertNotNull(repos);
			
		});
		
		Then("^there should be (\\d+) repository and the name of the repository should be \"([^\"]*)\"$",(Integer size,String repName)->{
			List<RepositoryInfo> result = repos.stream().filter(repo->repo.getId().equals(repName)).collect(Collectors.toList());
			assertThat(result.size(),is(equalTo(1)));
		});
	}
	
}
