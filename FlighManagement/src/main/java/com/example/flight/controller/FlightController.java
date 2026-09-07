package com.example.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.model.Flight;
import com.example.flight.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flight")
	public List<Flight> getAllFlights(@RequestParam(required = false) String flightType){
		if(flightType!=null)
			return flightService.findByFlightType(flightType);
		return flightService.getAllFlights();
	}
	
	@GetMapping("/flight/{flightNumber}")
	public Flight findByFlightType(@PathVariable String flightNumber){
		return flightService.getFlightByFlightNumber(flightNumber);
	}
	
	
	@PostMapping("/flight")
	public Flight creatFlight(@RequestBody Flight flight) {
		return flightService.createFlight(flight);
	}
	
	@PutMapping("/flight/{flightNumber}")
	public Flight updateFlight(@PathVariable String flightNumber,@RequestBody Flight flight) {
		return flightService.updateFlight(flightNumber, flight);
	}
	
	@DeleteMapping("/flight")
	public String deleteFlight(@RequestParam(required = false) String flightNumber,@RequestParam(required = false) String flightType) {
		if (flightNumber != null) {
	        flightService.deleteFlight(flightNumber);
	    } else if (flightType != null) {
	        flightService.deleteByFlightType(flightType);
	    } else {
	        return "Provide flightNumber or flightType";
	    }

	    return "Deleted Successfully";
	}
	


}
