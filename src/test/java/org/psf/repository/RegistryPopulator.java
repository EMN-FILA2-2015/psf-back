package org.psf.repository;

import org.psf.domain.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryPopulator {

	@Autowired
	private RegistryRepository repository;

	public void populate() {
		repository.deleteAll();
		repository.save(new Registry(1, "registry1", "host", 11111, "http"));
		repository.save(new Registry(2, "registry2", "host", 22222, "https"));
	}
}
