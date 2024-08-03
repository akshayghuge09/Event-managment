package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.Exception.ResourceNotFoundException;
import com.event.entity.Organizer;
import com.event.repository.OrganizerRepo;

@Service
public class OrganizerService {

	@Autowired
	OrganizerRepo organizerRepo;

	public Organizer createOrganizer(Organizer organizer) {
		return organizerRepo.save(organizer);
	}

	public Organizer getOrganizerById(int id) {
		return organizerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
	}

	public Organizer updateOrganizer(int id, Organizer organizerDetails) {
		Organizer organizer = getOrganizerById(id);
		organizer.setName(organizerDetails.getName());
		organizer.setContactInfo(organizerDetails.getContactInfo());
		return organizerRepo.save(organizer);
	}

	public void deleteOrganizer(int id) {
		Organizer organizer = getOrganizerById(id);
		organizerRepo.delete(organizer);
	}

	public List<Organizer> getAllOrganizers() {
		return organizerRepo.findAll();
	}

}
