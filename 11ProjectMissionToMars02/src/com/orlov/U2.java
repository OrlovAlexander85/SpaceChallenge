package com.orlov;

public class U2 extends Rocket {
    final int rocketCost = 120000000;
    final int rocketWeight = 18000;
    final int maxWeight = 29000;
    int totalWeight=18000;
    int chanceOfLaunchExplosion = 4*((maxWeight-totalWeight)/(maxWeight-rocketWeight));
    int chanceOfLandingCrash = 8*((maxWeight-totalWeight)/(maxWeight-rocketWeight));

    @Override
    public boolean launch() {
        return (int)( Math.random() * 100 + 1) > chanceOfLaunchExplosion;
    }
    @Override
    public boolean land() {
        return (int)( Math.random() * 100 + 1) > chanceOfLandingCrash;
    }
}
