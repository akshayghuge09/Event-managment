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

import com.event.entity.Venue;
import com.event.service.VenueServices;
@RestController
@RequestMapping("/venues")
public class VenueController {

	  @Autowired
	    private VenueServices venueServices;

	    @PostMapping
	    public ResponseEntity<Venue> createVenue( @RequestBody Venue venue) {
	        Venue createdVenue = venueServices.createVenue(venue);
	        return new ResponseEntity<>(createdVenue, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Venue> getVenueById(@PathVariable int id) {
	        Venue venue = venueServices.getVenueById(id);
	        return new ResponseEntity<>(venue, HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Venue> updateVenue(@PathVariable int id, @RequestBody Venue venueDetails) {
	        Venue updatedVenue = venueServices.updateVenue(id, venueDetails);
	        return new ResponseEntity<>(updatedVenue, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVenue(@PathVariable int id) {
	        venueServices.deleteVenue(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping
	    public List<Venue> getAllVenues() {
	        return venueServices.getAllVenues();
	    }
}
