package com.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.entity.Event;
@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

	List<Event> findByVenueId(int venueId);

	List<Event> findByOrganizerId(int organizerId);

}
