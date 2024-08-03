package com.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.entity.Event;
import com.event.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventService eventService;

	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		Event createdEvent = eventService.createEvent(event);
		return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity< List<Event>> getAllEvents() {
		List<Event> events =eventService.getAllEvents();
		return ResponseEntity.ok(events);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable int id) {
		Event event = eventService.getEventById(id);
		return new ResponseEntity<>(event, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable int id,  @RequestBody Event eventDetails) {
		Event updatedEvent = eventService.updateEvent(id, eventDetails);
		return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
		eventService.deleteEvent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/venue/{venueId}")
	public List<Event> getEventsByVenue(@PathVariable int venueId) {
		return eventService.getEventsByVenue(venueId);
	}

	@GetMapping("/organizer/{organizerId}")
	public List<Event> getEventsByOrganizer(@PathVariable int organizerId) {
		return eventService.getEventsByOrganizer(organizerId);
	}

}
