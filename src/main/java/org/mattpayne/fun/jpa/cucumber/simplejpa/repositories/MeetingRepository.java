package org.mattpayne.fun.jpa.cucumber.simplejpa.repositories;


import org.mattpayne.fun.jpa.cucumber.simplejpa.models.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}

