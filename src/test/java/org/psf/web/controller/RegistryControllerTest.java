package org.psf.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.psf.Application;
import org.psf.repository.RegistryPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class RegistryControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private RegistryPopulator populator;

    @Autowired
    private RegistryController controller;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RegistryController()).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        this.populator.populate();
    }
    
    @Test
    public void showTest200() throws Exception {
    	this.mockMvc.perform(get("/registries/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.name").value("registry1"))
        .andExpect(jsonPath("$.host").value("host"))
        .andExpect(jsonPath("$.protocol").value("http"))
        .andExpect(jsonPath("$.id").value(1));
    }
    
    @Test
    public void showTest404() throws Exception {
    	this.mockMvc.perform(get("/registries/3"))
        .andExpect(status().isNotFound());
    }
    
    @Test
    public void indexTest() throws Exception {
    	this.mockMvc.perform(get("/registries"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$[0].name").value("registry1"))
        .andExpect(jsonPath("$[0].host").value("host"))
        .andExpect(jsonPath("$[0].port").value(11111))
        .andExpect(jsonPath("$[0].protocol").value("http"))
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[1].name").value("registry2"))
        .andExpect(jsonPath("$[1].host").value("host"))
        .andExpect(jsonPath("$[1].port").value(22222))
        .andExpect(jsonPath("$[1].protocol").value("https"))
        .andExpect(jsonPath("$[1].id").value(2));
    }
}