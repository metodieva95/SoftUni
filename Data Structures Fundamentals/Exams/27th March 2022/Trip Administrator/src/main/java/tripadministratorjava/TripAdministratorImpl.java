package tripadministratorjava;

import java.util.*;
import java.util.stream.Collectors;

public class TripAdministratorImpl implements TripAdministrator {

    Map<String, Company> companies = new LinkedHashMap<>();
    Map<String, Trip> trips = new LinkedHashMap<>();
    Map<String, List<Trip>> tripsByCompanies = new LinkedHashMap<>();

    @Override
    public void addCompany(Company c) {
        if (exist(c)) {
            throw new IllegalArgumentException();
        }

        companies.put(c.name, c);
        tripsByCompanies.put(c.name, new ArrayList<>());
    }

    @Override
    public void addTrip(Company c, Trip t) {
        if (!exist(c) || exist(t)) {
            throw new IllegalArgumentException();
        }

        trips.put(t.id, t);

        if (c.tripOrganizationLimit == tripsByCompanies.get(c.name).size()) {
            throw new IllegalArgumentException();
        }

        tripsByCompanies.get(c.name).add(t);
    }

    @Override
    public boolean exist(Company c) {
        return companies.containsKey(c.name);
    }

    @Override
    public boolean exist(Trip t) {
        return trips.containsKey(t.id);
    }

    @Override
    public void removeCompany(Company c) {
        if (!exist(c)) {
            throw new IllegalArgumentException();
        }

        companies.remove(c.name);
        List<Trip> removedTrips = tripsByCompanies.remove(c.name);

        for (Trip trip : removedTrips) {
            trips.remove(trip.id);
        }
    }

    @Override
    public Collection<Company> getCompanies() {
        return companies.values();
    }

    @Override
    public Collection<Trip> getTrips() {
        return trips.values();
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        if (!exist(c) || !exist(t)) {
            throw new IllegalArgumentException();
        }

        List<Trip> companyTrips = tripsByCompanies.get(c.name);

        if (companyTrips.stream().noneMatch(tr -> tr.id.equals(t.id))) {
            throw new IllegalArgumentException();
        }

        companyTrips.remove(t);
        trips.remove(t.id);
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        return getCompanies().stream()
                .filter(c -> tripsByCompanies.get(c.name).size() > n)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        return getTrips().stream()
                .filter(tr -> tr.transportation.equals(t))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        return getTrips().stream()
                .filter(t -> t.price >= lo && t.price <= hi)
                .collect(Collectors.toList());
    }

}
