package org.psf.services.registry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.psf.Application;
import org.psf.service.registry.DockerRegistryService;
import org.psf.service.registry.RegistryServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class RegistryServiceFactoryTest {

	@Autowired
	private RegistryServiceFactory factory;

	@Autowired
	private DockerRegistryService dockerService;
	
	@Test
	public void testFactoryReturnsDockerService() {
		assertSame(dockerService, factory.get("docker"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFactoryThrowsExceptionOnInvalidServiceId() {
		factory.get("does not exists");
	}
}
