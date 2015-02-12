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
public class RegistryKindValidationTest {

	@Autowired
	private Validator validator;

	private RegistryKind kind;
	
	@Before
	public void setUp() {
		kind = new RegistryKind("Docker", "path", "127.0.0.1", 5000, false);
	}
	
	@Test
	public void testRegistryKindIsValid() {
		Set<ConstraintViolation<RegistryKind>> errors = validator.validate(kind, Default.class);
		assertTrue(errors.isEmpty());
	}
	
	@Test
	public void testNameCannotBeNull() {
		kind.setName(null);
		Set<ConstraintViolation<RegistryKind>> errors = validator.validateProperty(kind, "name", Default.class);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void testNameCannotBeEmpty() {
		kind.setName("");
		Set<ConstraintViolation<RegistryKind>> errors = validator.validateProperty(kind, "name", Default.class);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void testPortCannotBeNegative() {
		kind.setPort(-1);
		Set<ConstraintViolation<RegistryKind>> errors = validator.validateProperty(kind, "port", Default.class);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void testPortCannotBeGreaterThan65535() {
		kind.setPort(65536);
		Set<ConstraintViolation<RegistryKind>> errors = validator.validateProperty(kind, "port", Default.class);
		assertFalse(errors.isEmpty());
	}
	
}
