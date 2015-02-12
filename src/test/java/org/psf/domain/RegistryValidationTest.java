package org.psf.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.psf.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class RegistryValidationTest {

	@Autowired
	private Validator validator;

	private Registry registry;
	
	@Before
	public void setUp() {
		registry = new Registry("54dcb42cc830c4b0c26b9a34", "name", "host", 22222, "http");
	}
	
	@Test
	public void testRegistryIsValid() {
		Set<ConstraintViolation<Registry>> errors = validator.validate(registry, Default.class);
		assertTrue(errors.isEmpty());
	}
	
	@Test
	public void testNameCannotBeNull() {
		registry.setName(null);
		Set<ConstraintViolation<Registry>> errors = validator.validateProperty(registry, "name", Default.class);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void testNameCannotBeEmpty() {
		registry.setName("");
		Set<ConstraintViolation<Registry>> errors = validator.validateProperty(registry, "name", Default.class);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void testPortCannotBeNegative() {
		registry.setPort(-1);
		Set<ConstraintViolation<Registry>> errors = validator.validateProperty(registry, "port", Default.class);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void testPortCannotBeGreaterThan65535() {
		registry.setPort(65536);
		Set<ConstraintViolation<Registry>> errors = validator.validateProperty(registry, "port", Default.class);
		assertFalse(errors.isEmpty());
	}
	
}
