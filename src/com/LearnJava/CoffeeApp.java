package com.LearnJava;

import java.util.Scanner;

public class CoffeeApp {
    private static int machineWater = 400;
    private static int machineMilk = 540;
    private static int machineBeans = 120;
    private static int machineDisposableCups = 9;
    private static int machineMoney = 550;
    //Espresso Variables
    private static final int ESPRESSO_WATER_PER_CUP = 250;
    private static final int ESPRESSO_BEANS_PER_CUP = 16;
    private static final int ESPRESSO_PRICE_PER_CUP = 4;
    //Latte Variables
    private static final int LATTE_WATER_PER_CUP = 350;
    private static final int LATTE_MILK_PER_CUP = 75;
    private static final int LATTE_BEANS_PER_CUP = 20;
    private static final int LATTE_PRICE_PER_CUP = 7;
    //Cappuccino Variables
    private static final int CAPCINO_WATER_PER_CUP = 200;
    private static final int CAPCINO_MILK_PER_CUP = 100;
    private static final int CAPCINO_BEANS_PER_CUP = 12;
    private static final int CAPCINO_PRICE_PER_CUP = 6;


    public CoffeeApp() {
    }

    public void executeAction(String action, Scanner scanner) {
        switch (action) {
            case "buy":
                drinkMenu(scanner);
                machineCurrentState();
                break;
            case "fill":
                fillMachine(scanner);
                machineCurrentState();
                break;
            case "take":
                takeMachineMoney(scanner);
                machineCurrentState();
                break;
        }
    }

    //Display current state of coffee machine
    public void machineCurrentState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", machineWater);
        System.out.printf("%d ml of milk%n", machineMilk);
        System.out.printf("%d g of coffee beans%n", machineBeans);
        System.out.printf("%d disposable cups%n", machineDisposableCups);
        System.out.printf("$%d of money%n", machineMoney);
    }

    //Display drink menu selection (1 - Buy)
    public void drinkMenu(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso," +
                " 2 - latte, 3 - cappuccino:");
        int userSelection = scanner.nextInt();

        switch (userSelection) {
            case 1:
                calculateEspressoCost();
                break;
            case 2:
                calculateLatteCost();
                break;
            case 3:
                calculateCappuccinoCost();
                break;
        }
    }
    //Buy an Espresso
    public void calculateEspressoCost() {
        machineWater -= ESPRESSO_WATER_PER_CUP;
        machineBeans -= ESPRESSO_BEANS_PER_CUP;
        machineMoney += ESPRESSO_PRICE_PER_CUP;
        machineDisposableCups -= 1;
    }
    //Buy a latte
    public void calculateLatteCost() {
        machineWater -= LATTE_WATER_PER_CUP;
        machineMilk -= LATTE_MILK_PER_CUP;
        machineBeans -= LATTE_BEANS_PER_CUP;
        machineMoney += LATTE_PRICE_PER_CUP;
        machineDisposableCups -= 1;
    }
    //Buy a cappuccino
    public void calculateCappuccinoCost() {
        machineWater -= CAPCINO_WATER_PER_CUP;
        machineMilk -= CAPCINO_MILK_PER_CUP;
        machineBeans -= CAPCINO_BEANS_PER_CUP;
        machineMoney += CAPCINO_PRICE_PER_CUP;
        machineDisposableCups -= 1;
    }

    //Refill machine ingredients (2 - Fill)
    public void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        machineWater += addWater;
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        machineMilk += addMilk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        machineBeans += addBeans;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCups = scanner.nextInt();
        machineDisposableCups += addCups;
    }

    //Take money from machine (3 - Take)
    public void takeMachineMoney(Scanner scanner) {
        System.out.printf("I gave you $%d", machineMoney);
        machineMoney -= machineMoney;
    }

}
