package org.psf.repository;

import org.psf.domain.Registry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface RegistryRepository extends MongoRepository<Registry, String> {

}