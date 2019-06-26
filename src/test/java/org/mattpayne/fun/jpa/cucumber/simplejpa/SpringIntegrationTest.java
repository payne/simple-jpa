package org.mattpayne.fun.jpa.cucumber.simplejpa;


import org.mattpayne.fun.jpa.cucumber.simplejpa.repositories.MeetingRepository;
import org.mattpayne.fun.jpa.cucumber.simplejpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = SimpleJpaApplication.class)
@ContextConfiguration
public class SpringIntegrationTest {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MeetingRepository meetingRepository;


}

