package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        setButtonCapacity(buttonCapacity);
        drinks = new ArrayList<>();
    }

    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {

        if (drinks.size() < buttonCapacity) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {

        Drink drinkToRemove = drinks.stream().filter(d -> d.getName().equals(name)).findAny().orElse(null);

        if (drinkToRemove != null) {
            drinks.remove(drinkToRemove);
            return true;
        }
        return false;
    }

    public Drink getLongest() {

        return drinks.stream().max((f,s) -> f.getVolume() - s.getVolume()).orElse(null);
    }

    public Drink getCheapest() {


        return drinks.stream().min(Comparator.comparing(Drink::getPrice)).get();

    }

    public String buyDrink(String name) {
        Drink drinkToBuy = drinks.stream().filter(d -> d.getName().equals(name)).findAny().orElse(null);

        if (drinkToBuy != null) {
            return drinkToBuy.toString();
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Drinks available:");

        for (Drink drink : drinks) {
            sb.append(System.lineSeparator());
            sb.append(drink.toString());
        }

        return sb.toString();
    }
}
