package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.flight.model.Flight;
import com.example.flight.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Flight createFlight(Flight flight) {
		return flightRepository.save(flight);
	}
	
	public Flight getFlightByFlightNumber(String flightNumber) {
		return flightRepository.findById(flightNumber).orElse(null);
	}
	
	public Flight updateFlight(String flightNumber,Flight updatedFlight) {
		Flight flight = flightRepository.findById(flightNumber).orElse(null);
		if(flight!=null) {
			flight.setAvailableSeats(updatedFlight.getAvailableSeats());
			flight.setDestination(updatedFlight.getDestination());
			flight.setFlightType(updatedFlight.getFlightType());
			flight.setPrice(updatedFlight.getPrice());
			flight.setSource(updatedFlight.getSource());
			return flightRepository.save(flight);
			
		}
		return null;
	}
	
	public void deleteFlight(String flightNumber) {
		flightRepository.deleteById(flightNumber);
	}
	
	public List<Flight> findByFlightType(String flightType){
		return flightRepository.findByFlightType(flightType);
	}
	
	@Transactional
	public void deleteByFlightType(String flightType) {
		flightRepository.deleteByFlightType(flightType);
	}
	
	
}
