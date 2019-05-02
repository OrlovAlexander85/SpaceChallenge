package com.orlov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // Метод, создающий массив объектов типа Item используя параметры из переданного файла.
    public ArrayList<Item> loadItems(File fileWithItemList) {
        ArrayList<Item> itemsToLoad = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(fileWithItemList);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String array[] = line.split("=");
                Item item = new Item(array[0], Integer.parseInt(array[1]));
                itemsToLoad.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file");
        }
        return itemsToLoad;
    }

    // Загружаем ракету U1 объектами из списка полученного методом loadItems, создаем список из загруженных ракет.
    public ArrayList<U1> loadU1 (File file){
        ArrayList<U1> loadedU1List = new ArrayList<>();
        ArrayList<Item> itemsToLoad;
        itemsToLoad=loadItems(file);
        while (itemsToLoad.size() != 0) {
            U1 u1Rocket = new U1();
            int j=0;
            while (itemsToLoad.size() >j) {
                if (u1Rocket.canCarry(itemsToLoad.get(j), u1Rocket.totalWeight, u1Rocket.maxWeight)) {
                    u1Rocket.totalWeight += itemsToLoad.get(j).weight;
                    itemsToLoad.remove(j);
                }else if(j++<itemsToLoad.size()){
                    j++;
                }
            }
            loadedU1List.add(u1Rocket);
        }
        return loadedU1List;
    }

    // Загружаем ракету U2 объектами из списка полученного методом loadItems, создаем список из загруженных ракет.
    public ArrayList<U2> loadU2 (File file){
        ArrayList<U2> loadedU2List = new ArrayList<>();
        ArrayList<Item> itemsToLoad;
        itemsToLoad=loadItems(file);
        while (itemsToLoad.size() != 0) {
            U2 u2Rocket = new U2();
            int j=0;
            while (itemsToLoad.size() >j) {
                if (u2Rocket.canCarry(itemsToLoad.get(j), u2Rocket.totalWeight, u2Rocket.maxWeight)) {
                    u2Rocket.totalWeight += itemsToLoad.get(j).weight;
                    itemsToLoad.remove(j);
                }else if(j++<itemsToLoad.size()){
                    j++;
                }
            }
            loadedU2List.add(u2Rocket);
        }
        return loadedU2List;
    }

    public int runSimulation(File file, String rocketType){
        int totalBudget=0;
        if(rocketType=="u1") {
            ArrayList<U1> u1List;
            u1List = loadU1(file);
            while (u1List.size()!=0) {
                if (u1List.get(0).launch() && u1List.get(0).land()) {
                    totalBudget += u1List.get(0).rocketCost;
                    u1List.remove(0);
                }
                else if (u1List.get(0).launch() || u1List.get(0).land()) {
                    totalBudget += u1List.get(0).rocketCost;
                }
            }
        }
        if(rocketType=="u2") {
            ArrayList<U2> u2List;
            u2List = loadU2(file);
            while (u2List.size()!=0) {
                if (u2List.get(0).launch() && u2List.get(0).land()) {
                    totalBudget += u2List.get(0).rocketCost;
                    u2List.remove(0);
                }
                else if (u2List.get(0).launch() || u2List.get(0).land()) {
                    totalBudget += u2List.get(0).rocketCost;
                }
            }
        }
        return totalBudget;
    }

}
