package com.orlov;

public class U1 extends Rocket{
    final int rocketCost = 100000000;
    final int rocketWeight = 10000;
    final int maxWeight = 18000;
    int totalWeight=10000;
    int chanceOfLaunchExplosion = 5*((maxWeight-totalWeight)/(maxWeight-rocketWeight));
    int chanceOfLandingCrash = ((maxWeight-totalWeight)/(maxWeight-rocketWeight));

    @Override
    public boolean launch() {
        return (int)( Math.random() * 100 + 1) > chanceOfLaunchExplosion;
    }
    @Override
    public boolean land() {
        return (int)( Math.random() * 100 + 1) > chanceOfLandingCrash;
    }

}
