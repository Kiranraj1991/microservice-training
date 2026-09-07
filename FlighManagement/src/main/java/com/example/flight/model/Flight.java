package com.example.flight.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Flight {

	@Id
	private String flightNumber;
	private String flightType;
	private String source;
	private String destination;
	private double price;
	private int availableSeats;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Flight(String flightNumber, String flightType, String source, String destination, double price,
			int availableSeats) {
		super();
		this.flightNumber = flightNumber;
		this.flightType = flightType;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.availableSeats = availableSeats;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
