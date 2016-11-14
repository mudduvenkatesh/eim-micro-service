package net.trigyan.glide.repository.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.rdf4j.repository.manager.RepositoryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestServiceStepsIT extends SpringBaseIT {

	Logger logger = LoggerFactory.getLogger(RestServiceStepsIT.class);
	ResponseEntity<Collection<RepositoryInfo>> response = null;
	ResponseEntity<RepositoryInfo> putResponse = null;
	// Collection<RepositoryInfo> result=null;
	// @Autowired
	// protected RestTemplate restTemplate;
	// @Autowired
	// RepositoryAccessService repositoryAccessService;
	

	@When("^the client calls /repositories$")
	public void the_client_calls_repositories() throws Throwable {
		final String url = "http://localhost:16008/eim/repositories";
		response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<Collection<RepositoryInfo>>() {
				});
		//System.out.println("No of repos = "+response.getBody().size());
		//System.out.println(response);
		assertThat(response!=null);
		// executeGet(url);
	}

	@Then("^the client receives status code of (\\d+)$")
	public void client_receives_status_code_of(Integer statusCode) throws Throwable {
		assertThat("status code is incorrect : ", response.getStatusCode().value(), is(statusCode));

	}

	@Then("^the client receives server repository list at least (\\d+)$")
	public void client_receives_server_rep_list(Integer size) {
		assertThat(response.getBody().size() >= 1);
	}

//	@Then("^there is a repository by name \"([^\"]*)\"$")
//	public void there_is_a_repo_by_name_system(String repoName) {
//		long size = response.getBody().stream().filter(repo -> repo.getId().equals(repoName)).count();
//		assertThat(size == 1);
//	}
//
//	@When("^the client calls POST /createRepository with \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void the_client_calls_createRepository(String id, String name) {
//		final String url = "http://localhost:16008/eim/createRepository";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//		map.add("id", id);
//		map.add("name", name);
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//		//ResponseEntity<String> putResponse1 = restTemplate.postForEntity(url, request, String.class);
//		putResponse = restTemplate.postForEntity(url, request, RepositoryInfo.class);
//		assertThat(putResponse!=null);
//		logger.info(putResponse.getBody().toString());
//	
//	}
//
//	@Then("^there is a new repository by name \"([^\"]*)\"$")
//	public void there_is_a_new_repo_by_name(String name) {
//		final String url = "http://localhost:16008/eim/repositories/";
//		Map<String, String> params = new HashMap<String, String>();
//	    params.put("id", name);
//	    ResponseEntity<String> response2 = restTemplate.getForEntity(url,String.class,params); 
//	    assertThat(response2.getBody()!=null);
//	    logger.info(response2.getBody());
//	    
//	     
//	    
//	}
	

}
