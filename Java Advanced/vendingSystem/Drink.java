package vendingSystem;

import java.math.BigDecimal;

public class Drink {

    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        setName(name);
        setPrice(price);
        setVolume(volume);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return new BigDecimal(String.valueOf(price));
    }

    public void setPrice(BigDecimal price) {
        this.price = new BigDecimal(String.valueOf(price));
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        //"Name: {name}, Price: ${price}, Volume: {volume} ml"
        String result = String.format("Name: %s, Price: $%.1f, Volume: %d ml", name, price, volume);

        return result.toString();
    }
}
