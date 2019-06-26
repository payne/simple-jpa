package org.mattpayne.fun.jpa.cucumber.simplejpa;

import org.mattpayne.fun.jpa.cucumber.simplejpa.models.Meeting;
import org.mattpayne.fun.jpa.cucumber.simplejpa.models.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

	private Person person;

	@When("^the client calls /version$")
	public void the_client_issues_GET_version() throws Throwable {
		System.out.println("/version is being called");
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		System.out.println("Hoping for statusCode=" + statusCode);
	}

	@And("^the client receives server version (.+)$")
	public void the_client_receives_server_version_body(String version) throws Throwable {
		System.out.println("cliente recieves server version=" + version);
	}

	@Given("^a person named (.+)$")
	public void given_a_person(String name) {
		this.person = new Person();
		person.setName(name);
		personRepository.save(person);
	}

	@And("person goes to meeting called {string}")
	public void person_goes_to_meeting_called(String meetingName) {
		Meeting meeting = new Meeting();
		meeting.setName(meetingName);
		meetingRepository.save(meeting);
		person = personRepository.findById(person.getId()).get();
		Set<Meeting> meetings = this.person.getMeetings();
		if (meetings == null)
			meetings = new HashSet<>();
		meetings.add(meeting);
		personRepository.save(person);
	}

	@Then("person has {int} meetings")
	public void person_has_meetings(Integer n) {
		//	assertThat(person.getMeetings().size(), is(n));
		Set<Meeting> meetings = person.getMeetings();
		// Do I really need to read it from the database again??
		Optional<Person> p = personRepository.findById(person.getId());
		Person alsoPerson = p.get();
		meetings = alsoPerson.getMeetings();
		System.out.println("\n\n\n\n");
		System.out.println(meetings);
		assertThat(meetings.size(), is(n));
	}

}
