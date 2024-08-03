package com.event.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String eventName;

	private String eventDate;

	private String description;

	@ManyToOne
	@JoinColumn(name="organizer_id",referencedColumnName="id",nullable = false)
    private Organizer organizer;

	@ManyToOne
	@JoinColumn(name="venue_id",referencedColumnName="id",nullable = false)
    private Venue venue;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	
	public Event(int id, String eventName, String eventDate, String description, Organizer organizer, Venue venue) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.organizer = organizer;
		this.venue = venue;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Organizer getOrganizer() {
		return organizer;
	}


	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}

}
