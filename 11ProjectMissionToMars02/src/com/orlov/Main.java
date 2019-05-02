package com.orlov;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        U1 u1 = new U1();
        U2 u2 = new U2();
        Simulation simulation = new Simulation();
        File phase1 = new File("phase-1.txt");
        File phase2 = new File("phase-2.txt");
        
        System.out.println("Total budget for Mars mission using U1 rockets is: $" +
                ((simulation.runSimulation(phase1,"u1"))+(simulation.runSimulation(phase2,"u1")))/1000000+"Million");
        System.out.println("Total budget for Mars mission using U2 rockets is: $" +
                ((simulation.runSimulation(phase1,"u2"))+(simulation.runSimulation(phase2,"u2")))/1000000+"Million");
    }

}
