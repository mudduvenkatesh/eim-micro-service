package net.trigyan.glide;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EimMicroServiceApplicationTests {

	@Value("${glide.eim.graphdb.server.url}")
	String graphDBServer;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new EimMicroServiceApplication()).build();
	}

	@Test
	public void test() throws Exception {
		// mvc.perform(MockMvcRequestBuilders.get("/")
		// .accept(MediaType.TEXT_PLAIN))
		// .andExpect(MockMvcResultMatchers.status().isOk())
		// .andExpect(MockMvcResultMatchers.content()
		// .string(
		// Matchers.equalTo("Hello World from Spring boot and Semantic Web Glide
		// by Trigyan running on "+graphDBServer)));
	}

}
