package com.orlov;

public class Rocket implements SpaceShip{
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item, int totalWeight, int maxWeight) {
        return (item.weight + totalWeight) <= maxWeight;
    }

    @Override
    public int carry (Item item, int totalWeight) {
        totalWeight+=item.weight;
        return totalWeight;
    }
}
