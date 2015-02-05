package org.psf.web.controller;

import java.util.List;

import org.psf.domain.Registry;
import org.psf.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registries")
public class RegistryController {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	class RegistryNotFound extends RuntimeException {
	}
	
	@Autowired
	private RegistryRepository repository;
	
    @RequestMapping("/{id}")
    public Registry show(@PathVariable("id") long id) {
    	Registry registry = repository.findOne(id);
    	if (registry != null)
    		return registry;
    	else
    		throw new RegistryNotFound();
    }

    @RequestMapping("")
    public List<Registry> index() {
    	return repository.findAll();
    }
}