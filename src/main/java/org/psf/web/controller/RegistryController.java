package org.psf.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.psf.domain.Registry;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/registries")
public class RegistryController {

    @RequestMapping("/{id}")
    public Registry show(@PathVariable("id") long id) {
        return new Registry(id);
    }

    @RequestMapping("")
    public List<Registry> index() {
    	List<Registry> registries = new ArrayList<Registry>();
    	registries.add(new Registry(1));
    	registries.add(new Registry(2));
    	return registries;
    }
}