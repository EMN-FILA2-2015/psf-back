package org.psf.service.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryServiceFactory {

	@Autowired
	private DockerRegistryService dockerRegistryService;

	// TODO: See ServiceLocatorFactoryBean 
	public RegistryService get(String serviceId) {
		switch (serviceId) {
			case "docker": return dockerRegistryService;
			default: 
				throw new IllegalArgumentException("Given registry service does not exists");
		}
	}
	
}
