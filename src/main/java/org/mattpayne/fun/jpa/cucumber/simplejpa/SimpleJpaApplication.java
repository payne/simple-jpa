package org.mattpayne.fun.jpa.cucumber.simplejpa;

import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.mattpayne.fun.jpa.cucumber.simplejpa.models.Meeting;
import org.mattpayne.fun.jpa.cucumber.simplejpa.models.Person;
import org.mattpayne.fun.jpa.cucumber.simplejpa.repositories.MeetingRepository;
import org.mattpayne.fun.jpa.cucumber.simplejpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleJpaApplication implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Person matt = new Person();
		matt.setName("Matt Payne");
		matt.setEmail("Matt@MattPayne.org");
		Meeting m1 = new Meeting();
		m1.setDate(new Date(2019, 06, 15));
		m1.setLocation("Butterloo");
		meetingRepository.save(m1);
		Set<Meeting> meetings=new HashSet<>();
		meetings.add(m1);
		Meeting m2 = new Meeting();
		m2.setDate(new Date(2019, 06, 16));
		m2.setLocation("Butterloo");
		meetingRepository.save(m2);
		meetings.add(m2);
		matt.setMeetings(meetings);
		personRepository.save(matt);

		Optional<Person> alsoMatt = personRepository.findById(matt.getId());
		boolean p = alsoMatt.isPresent();
		Person matt2 = alsoMatt.get();
 		int numMeetings = matt2.getMeetings().size();
		System.out.println("\n\n"+numMeetings+"\n\n");
	}


}
