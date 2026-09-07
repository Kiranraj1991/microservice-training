package com.example.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flight.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{
	
	List<Flight> findByFlightType(String flightType);
	
	void deleteByFlightType(String flightType);
}
