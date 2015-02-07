package org.psf.web.controller;

import java.util.List;

import org.psf.domain.Registry;
import org.psf.repository.RegistryRepository;
import org.psf.web.exception.RegistryNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registries")
public class RegistryController {
	
	@Autowired
	private RegistryRepository repository;

    @RequestMapping("/{id}")
    public Registry showRegistry(@PathVariable("id") long id) {
    	Registry registry = repository.findOne(id);
    	if (registry != null)
    		return registry;
    	else
    		throw new RegistryNotFound();
    }
    
    @RequestMapping("")
    public List<Registry> listRegistries() {
    	return repository.findAll();
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) 
    public Registry createRegistry(@RequestBody Registry registry) {	
    	return repository.save(registry);	    		
    }
}