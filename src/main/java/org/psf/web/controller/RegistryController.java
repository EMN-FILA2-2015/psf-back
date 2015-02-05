package org.psf.web.controller;

import java.util.List;

import org.psf.domain.Registry;
import org.psf.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registries")
public class RegistryController {

	@Autowired
	private RegistryRepository repository;
	
    @RequestMapping("/{id}")
    public Registry show(@PathVariable("id") long id) {
        return repository.findOne(id);
    }

    @RequestMapping("")
    public List<Registry> index() {
    	return repository.findAll();
    }
}