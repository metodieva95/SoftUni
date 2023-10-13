package barbershopjava;

import java.util.*;
import java.util.stream.Collectors;

public class BarberShopImpl implements BarberShop {

    Map<String, Barber> barbers = new LinkedHashMap<>();
    Map<String, Client> clients = new LinkedHashMap<>();
    Map<String, List<Client>> barbersClients = new LinkedHashMap<>();

    @Override
    public void addBarber(Barber b) {
        if (exist(b)) {
            throw new IllegalArgumentException();
        }
        barbers.put(b.name, b);
        barbersClients.put(b.name, new ArrayList<>());
    }

    @Override
    public void addClient(Client c) {
        if (exist(c)) {
            throw new IllegalArgumentException();
        }
        clients.put(c.name, c);
    }

    @Override
    public boolean exist(Barber b) { return barbers.containsKey(b.name); }

    @Override
    public boolean exist(Client c) { return clients.containsKey(c.name); }

    @Override
    public Collection<Barber> getBarbers() { return barbers.values(); }

    @Override
    public Collection<Client> getClients() { return clients.values(); }

    @Override
    public void assignClient(Barber b, Client c) {
        if (!exist(b) || !exist(c)) {
            throw new IllegalArgumentException();
        }
        barbersClients.get(b.name).add(c);
        c.barber = b;
    }

    @Override
    public void deleteAllClientsFrom(Barber b) {
        if (!exist(b)) {
            throw new IllegalArgumentException();
        }
        barbersClients.get(b.name).clear();
    }

    @Override
    public Collection<Client> getClientsWithNoBarber() {
        return clients.values().stream()
                .filter(c -> c.barber == null)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithClientsCountDesc() {
        return barbers.values().stream()
                .sorted(Comparator.comparing(
                        (Barber b) -> barbersClients.get(b.name).size()).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        return barbers.values().stream()
                .sorted(Comparator.comparing((Barber b) -> b.stars).reversed()
                        .thenComparing((Barber b) -> b.haircutPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc() {
        return clients.values().stream()
                .filter(c -> c.barber != null)
                .sorted(Comparator.comparing((Client c) -> c.age).reversed()
                        .thenComparing((Client c) -> c.barber.stars).reversed())
                .collect(Collectors.toList());
    }
}
