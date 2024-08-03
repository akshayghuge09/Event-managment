package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.Exception.ResourceNotFoundException;
import com.event.entity.Venue;
import com.event.repository.VenueRepo;

@Service
public class VenueServices {
	
	@Autowired
	VenueRepo venueRepo;
	 public Venue createVenue(Venue venue) {
	        return venueRepo.save(venue);
	    }

	    public Venue getVenueById(int id) {
	        return venueRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
	    }

	    public Venue updateVenue(int id, Venue venueDetails) {
	        Venue venue = getVenueById(id);
	        venue.setName(venueDetails.getName());
	        venue.setLocation(venueDetails.getLocation());
	        venue.setCapacity(venueDetails.getCapacity());
	        return venueRepo.save(venue);
	    }

	    public void deleteVenue(int id) {
	        Venue venue = getVenueById(id);
	        venueRepo.delete(venue);
	    }

	    public List<Venue> getAllVenues() {
	        return venueRepo.findAll();
	    }

}
