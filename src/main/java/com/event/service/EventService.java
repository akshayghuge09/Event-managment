package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.Exception.ResourceNotFoundException;
import com.event.entity.Event;
import com.event.repository.EventRepo;


@Service
public class EventService {
	
	@Autowired
	EventRepo eventRepo;
	
	 public Event createEvent(Event event) {
	        return eventRepo.save(event);
	    }

	    public List<Event> getAllEvents() {
	        return eventRepo.findAll();
	    }

	    public Event getEventById(int id) {
	        return eventRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("event not found"));
	    }

	    public Event updateEvent(int id, Event eventDetails) {
	        Event event = getEventById(id);
	        event.setEventName(eventDetails.getEventName());
	        event.setEventDate(eventDetails.getEventDate());
	        event.setDescription(eventDetails.getDescription());
	        event.setOrganizer(eventDetails.getOrganizer());
	        event.setVenue(eventDetails.getVenue());
	        return eventRepo.save(event);
	    }

	    public void deleteEvent(int id) {
	        Event event = getEventById(id);
	        eventRepo.delete(event);
	    }

	    public List<Event> getEventsByVenue(int venueId) {
	        return eventRepo.findByVenueId(venueId);
	    }

	    public List<Event> getEventsByOrganizer(int organizerId) {
	        return eventRepo.findByOrganizerId(organizerId);
	    }

}
