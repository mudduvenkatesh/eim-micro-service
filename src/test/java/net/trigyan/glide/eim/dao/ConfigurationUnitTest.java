package net.trigyan.glide.eim.dao;

import java.util.Map;

import org.eclipse.rdf4j.model.Value;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.trigyan.glide.eim.Dao.ConfigurationDao;
import net.trigyan.glide.repository.model.Configuration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationUnitTest {

	Logger logger = LoggerFactory.getLogger(ConfigurationUnitTest.class);
	
	@Autowired
	ConfigurationDao configurationDao;
	@Test
	public void test() {
		Map<String, Configuration> configs = configurationDao.getEIMConfiguration();
		Configuration prop = configs.get(Configuration.baseIRIPropertyName);
		Value baseIRIProp = prop.propertyValue();
		logger.info("Base IRI is " + baseIRIProp.stringValue());
	}

}
