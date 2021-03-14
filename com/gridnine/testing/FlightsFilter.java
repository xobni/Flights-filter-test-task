package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightsFilter {
    private List<Flight> flights;

    FlightsFilter(List<Flight> flights) {
	// System.out.println(flights);
	this.flights = flights;
    }

    private List<Flight> getFilteredResult(Predicate<Flight> predicate) {
	return flights.stream().filter(predicate).collect(Collectors.toList());
    }

    public Predicate<Flight> fillPredicate(String conditions) {
	Predicate<Flight> predicate = null;
	return predicate;
    }

    void printAllFlights() {
	int i = 0;
	for (Flight flight : flights) {
	    System.out.println("Рейс №" + i + flight);
	    i++;
	}
    }

    void printFilteredFlights(Predicate<Flight> predicate) {
	int i = 1;
	// System.out.println("Printing filtered result");
	for (Flight flight : getFilteredResult(predicate)) {
	    System.out.println("Flight № " + i + " " + flight);
	    i++;
	}
    }

}
