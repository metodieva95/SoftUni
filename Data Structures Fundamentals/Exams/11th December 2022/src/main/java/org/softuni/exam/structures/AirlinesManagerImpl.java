package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class AirlinesManagerImpl implements AirlinesManager {

    private Map<String, Airline> airlinesById;
    private Map<String, Flight> flightsById;
    private Map<String, List<Flight>> flightsByAirline;
    private  Set<Flight> completedFlights;

    public AirlinesManagerImpl() {
        airlinesById = new LinkedHashMap<>();
        flightsById = new LinkedHashMap<>();
        flightsByAirline = new LinkedHashMap<>();
        completedFlights = new LinkedHashSet<>();
    }

    @Override
    public void addAirline(Airline airline) {
        airlinesById.put(airline.getId(), airline);
        flightsByAirline.put(airline.getId(), new ArrayList<>());
    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }

        flightsById.put(flight.getId(), flight);
        flightsByAirline.get(airline.getId()).add(flight);
    }

    @Override
    public boolean contains(Airline airline) {
        return airlinesById.containsKey(airline.getId());
    }

    @Override
    public boolean contains(Flight flight) {
        return flightsById.containsKey(flight.getId());
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {
        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }

        airlinesById.remove(airline.getId());

        List<Flight> removedAirlineFlights = flightsByAirline.get(airline.getId());
        for (Flight flight : removedAirlineFlights) {
            flightsById.remove(flight.getId());
        }
    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return flightsById.values();
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {
        if (!contains(flight) || !contains(airline)) {
            throw new IllegalArgumentException();
        }

        Flight completedFlight = flightsById.get(flight.getId());
        completedFlight.setCompleted(true);

        completedFlights.add(completedFlight);

        return completedFlight;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return completedFlights;
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        return flightsById.values().stream()
                .sorted(Comparator.comparing(Flight::isCompleted)
                        .thenComparing(Flight::getNumber))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return airlinesById.values().stream()
                .sorted(Comparator.comparing(Airline::getRating).reversed()
                        .thenComparing((Airline a) -> flightsByAirline.get(a.getId()).size()).reversed()
                        .thenComparing(Airline::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        return airlinesById.values().stream()
                .filter(a -> flightsByAirline.get(a.getId()).stream().anyMatch(
                        f -> !f.isCompleted()
                                && f.getOrigin().equals(origin)
                                && f.getDestination().equals(destination)))
                .collect(Collectors.toList());
    }
}
