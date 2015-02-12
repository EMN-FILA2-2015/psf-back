package org.psf.web.controller;

import static com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb.InMemoryMongoRuleBuilder.newInMemoryMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.psf.Application;
import org.psf.repository.RegistryPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lordofthejars.nosqlunit.mongodb.InMemoryMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class RegistryControllerTest {

	@ClassRule
	public static InMemoryMongoDb inMemoryMongoDb = newInMemoryMongoDbRule().build();
	
	@Rule
	public MongoDbRule embeddedMongoDbRule = newMongoDbRule().defaultEmbeddedMongoDb(MongoDbTestConfig.databaseName);
	
    private MockMvc mockMvc;

    @Autowired
    private RegistryPopulator populator;

    @Autowired
    private RegistryController controller;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        this.populator.populate();
    }
        
    @Test
    public void showRegistryTest200() throws Exception {
    	this.mockMvc.perform(get("/registries/54dcb42cc830c4b0c26b9a34"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void showRegistryTest404() throws Exception {
    	this.mockMvc.perform(get("/registries/54dcb42cc830c4b0c26b9a36"))
        .andExpect(status().isNotFound());
    }
    
    @Test
    public void listRegistriesTest200() throws Exception {
    	this.mockMvc.perform(get("/registries"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void createRegistryTest201() throws Exception {
    	String payload = "{ \"name\": \"registry\", \"host\": \"host\", \"protocol\": \"https\", \"port\": 22222 }";
    	this.mockMvc.perform(post("/registries")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(payload))
    	.andExpect(status().isCreated())
    	.andExpect(content().contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void createRegistryTest400() throws Exception {
    	String payload = "{ \"name\": \"\", \"host\": \"host\", \"protocol\": \"https\", \"port\": -1 }";
    	this.mockMvc.perform(post("/registries")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(payload))
    	.andExpect(status().isBadRequest());
    }
}