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
		repository.save(new Registry("54dcb42cc830c4b0c26b9a34", "registry1", "host", 11111, "http"));
		repository.save(new Registry("54dcb42cc830c4b0c26b9a35", "registry2", "host", 22222, "https"));
	}
}
