package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.*;
import java.util.stream.Collectors;

public class RenovationImpl implements Renovation {

    private final Deque<Tile> tileStack;
    private final Deque<Laminate> laminateStack;
    private double totalTileArea;

    public RenovationImpl() {
        this.tileStack = new ArrayDeque<>();
        this.laminateStack = new ArrayDeque<>();
        this.totalTileArea = 0;
    }


    @Override
    public void deliverTile(Tile tile) {
        if (totalTileArea > 30) {
            throw new IllegalArgumentException();
        }

        tileStack.push(tile);
        totalTileArea += tile.height * tile.width;
    }

    @Override
    public void deliverFlooring(Laminate laminate) {
        laminateStack.push(laminate);
    }

    @Override
    public double getDeliveredTileArea() {
        return totalTileArea;
    }

    @Override
    public boolean isDelivered(Laminate laminate) {
        return laminateStack.contains(laminate);
    }

    @Override
    public void returnTile(Tile tile) {
        if (!tileStack.contains(tile)) {
            throw new IllegalArgumentException();
        }

        tileStack.remove(tile);
        totalTileArea -= tile.width * tile.height;
    }

    @Override
    public void returnLaminate(Laminate laminate) {
        if (!isDelivered(laminate)) {
            throw new IllegalArgumentException();
        }

        laminateStack.remove(laminate);
    }

    @Override
    public Collection<Laminate> getAllByWoodType(WoodType wood) {
        return laminateStack.stream()
                .filter(l -> l.woodType.equals(wood))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Tile> getAllTilesFitting(double width, double height) {
        return tileStack.stream()
                .filter(t -> t.width <= width && t.height <= height)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Tile> sortTilesBySize() {
        return tileStack.stream()
                .sorted((l, r) -> {
                    double leftArea = l.height * l.width;
                    double rightArea = r.height * r.width;

                    if (leftArea == rightArea) {
                       return Double.compare(l.depth, r.depth);
                    }

                    return Double.compare(leftArea, rightArea);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Laminate> layFlooring() {
        return laminateStack.iterator();
    }
}
