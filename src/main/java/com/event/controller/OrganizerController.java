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

import com.event.entity.Organizer;
import com.event.service.OrganizerService;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;

	@PostMapping
	public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
		Organizer createdOrganizer = organizerService.createOrganizer(organizer);
		return new ResponseEntity<>(createdOrganizer, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Organizer> getOrganizerById(@PathVariable int id) {
		Organizer organizer = organizerService.getOrganizerById(id);
		return new ResponseEntity<>(organizer, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Organizer> updateOrganizer(@PathVariable int id, @RequestBody Organizer organizerDetails) {
		Organizer updatedOrganizer = organizerService.updateOrganizer(id, organizerDetails);
		return new ResponseEntity<>(updatedOrganizer, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganizer(@PathVariable int id) {
		organizerService.deleteOrganizer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public List<Organizer> getAllOrganizers() {
		return organizerService.getAllOrganizers();
	}

}
