package org.psf.service.registry;

import org.psf.domain.Registry;
import org.springframework.stereotype.Service;

@Service
public class DockerRegistryService implements RegistryService {

	@Override
	public boolean isAvailable(Registry registry) {
		return false;
	}

}
