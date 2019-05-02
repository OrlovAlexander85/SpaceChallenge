package com.orlov;

public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry (Item item, int totalWeight, int maxWeight);
    int carry (Item item, int totalWeight);
}
