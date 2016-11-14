package net.trigyan.glide.service;

import java.util.Map;

import org.eclipse.rdf4j.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.trigyan.glide.eim.Dao.ConfigurationDao;
import net.trigyan.glide.repository.model.Configuration;

@RestController
public class ConfigurationController {
	@Autowired
	ConfigurationDao configurationDao;
	Logger logger = LoggerFactory.getLogger(ConfigurationController.class);
	
	@RequestMapping(value = "/config/eim",method = RequestMethod.GET)
	public Map<String,Configuration> getEIMConfiguration() {
		Map<String, Configuration> configs = configurationDao.getEIMConfiguration();
		return configs;
	}
}
