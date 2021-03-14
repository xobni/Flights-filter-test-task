package com.gridnine.testing;

import static com.gridnine.testing.Predicates.isArrivalDepartureErrorInFlight;
import static com.gridnine.testing.Predicates.isDateDepartureBefore;
import static com.gridnine.testing.Predicates.isTimeOnTheGroundGreaterThanTwoH;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	List<Flight> testFlights = FlightBuilder.createFlights();
	FlightsFilter flightsFilter = new FlightsFilter(testFlights);

	System.out.println("Flights already departured:");
	flightsFilter.printFilteredFlights(isDateDepartureBefore(LocalDateTime.now()));

	System.out.println(" ");
	System.out.println("Flights departured before arriving:");
	flightsFilter.printFilteredFlights(isArrivalDepartureErrorInFlight);

	System.out.println(" ");
	System.out.println("Flights with more 2 hours time on the ground:");
	flightsFilter.printFilteredFlights(isTimeOnTheGroundGreaterThanTwoH);
    }

}
