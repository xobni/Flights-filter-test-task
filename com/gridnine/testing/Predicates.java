package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Predicate;

public class Predicates {

    public static Predicate<Flight> isDateArrivalAfter(LocalDateTime date) {
	return p -> (p.getSegments().get(0).getArrivalDate().isAfter(date));
    }

    public static Predicate<Flight> isDateArrivalBefore(LocalDateTime date) {
	return p -> (p.getSegments().get(0).getArrivalDate().isBefore(date));
    }

    public static Predicate<Flight> isDateDepartureAfter(LocalDateTime date) {
	return p -> (p.getSegments().get(0).getDepartureDate().isAfter(date));
    }

    public static Predicate<Flight> isDateDepartureBefore(LocalDateTime date) {
	return p -> (p.getSegments().get(0).getDepartureDate().isBefore(date));
    }

    public static Predicate<Flight> isArrivalDepartureErrorInFlight = new Predicate<Flight>() {
	@Override
	public final boolean test(Flight f) {
	    for (Segment segment : f.getSegments()) {
		if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
		    return true;
		}
	    }
	    return false;
	}
    };

    public static Predicate<Flight> isTimeOnTheGroundGreaterThanTwoH = new Predicate<Flight>() {
	@Override
	public boolean test(Flight f) {
	    LocalDateTime arrived = f.getSegments().get(0).getDepartureDate();
	    Duration duration = Duration.ZERO;
	    for (Segment segment : f.getSegments()) {
		duration = duration.plus(Duration.between(arrived, segment.getDepartureDate()));
		arrived = segment.getArrivalDate();
		if (duration.getSeconds() > 3600) {
		    return true;
		}
	    }
	    return false;
	}
    };

}
