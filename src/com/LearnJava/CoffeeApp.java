package com.LearnJava;

import java.util.Scanner;

public class CoffeeApp {
    private static int machineWater = 400;
    private static int machineMilk = 540;
    private static int machineBeans = 120;
    private static int machineDisposableCups = 9;
    private static int machineMoney = 550;
    private static boolean isFinished = false;
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

    public void executeAction(Scanner scanner) {

        while (isFinished == false) {
            writeAction();
            String action = scanner.next();
            switch (action) {
                case "buy":
                    drinkMenu(scanner);
                    break;
                case "fill":
                    fillMachine(scanner);
                    break;
                case "take":
                    takeMachineMoney();
                    break;
                case "remaining":
                    machineCurrentState();
                    break;
                case "exit":
                    isFinished = true;
            }
        }

    }

    public void writeAction() {
        System.out.printf("%nWrite action (buy, fill, take, remaining, exit):%n");
    }

    //Display current state of coffee machine
    public void machineCurrentState() {
        System.out.printf("%nThe coffee machine has:%n");
        System.out.printf("%d ml of water%n", machineWater);
        System.out.printf("%d ml of milk%n", machineMilk);
        System.out.printf("%d g of coffee beans%n", machineBeans);
        System.out.printf("%d disposable cups%n", machineDisposableCups);
        System.out.printf("$%d of money%n", machineMoney);
    }

    //Display drink menu selection (1 - Buy)
    public void drinkMenu(Scanner scanner) {

        askDrinkMenu();

        if (scanner.hasNextInt()) {

            switch (scanner.nextInt()) {
                case 1:
                    calculateEspressoCost();
                    executeAction(scanner);
                    break;
                case 2:
                    calculateLatteCost();
                    executeAction(scanner);
                    break;
                case 3:
                    calculateCappuccinoCost();
                    executeAction(scanner);
                    break;
            }
        } else {
            executeAction(scanner);
        }
    }

    //Ask what drink
    public void askDrinkMenu() {
        System.out.printf("%nWhat do you want to buy? 1 - espresso," +
                " 2 - latte, 3 - cappuccino, back - to main menu:%n");
    }
    //Buy an Espresso
    public void calculateEspressoCost() {
        if (machineWater >= ESPRESSO_WATER_PER_CUP &&
                machineBeans >= ESPRESSO_BEANS_PER_CUP && machineDisposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            machineWater -= ESPRESSO_WATER_PER_CUP;
            machineBeans -= ESPRESSO_BEANS_PER_CUP;
            machineMoney += ESPRESSO_PRICE_PER_CUP;
            machineDisposableCups -= 1;
        } else {
            checkIngredientsMissing(ESPRESSO_WATER_PER_CUP, ESPRESSO_BEANS_PER_CUP);
        }

    }

    //Check whether coffee can be made for Espresso
    public void checkIngredientsMissing(int water, int beans) {
        if (machineWater < water) {
            System.out.println("Sorry, not enough water");
        } else if (machineBeans < beans) {
            System.out.println("Sorry, not enough beans");
        } else if (machineDisposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        }
    }

    //Buy a latte
    public void calculateLatteCost() {
        if (machineWater >= LATTE_WATER_PER_CUP &&
                machineBeans >= LATTE_BEANS_PER_CUP &&
                machineMilk >= LATTE_MILK_PER_CUP && machineDisposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            machineWater -= LATTE_WATER_PER_CUP;
            machineBeans -= LATTE_BEANS_PER_CUP;
            machineMilk -= LATTE_MILK_PER_CUP;
            machineMoney += LATTE_PRICE_PER_CUP;
            machineDisposableCups -= 1;
        } else {
            checkIngredientsMissing(LATTE_WATER_PER_CUP, LATTE_MILK_PER_CUP, LATTE_BEANS_PER_CUP);
        }
    }
    //Buy a cappuccino
    public void calculateCappuccinoCost() {
        if (machineWater >= CAPCINO_WATER_PER_CUP &&
                machineBeans >= CAPCINO_BEANS_PER_CUP &&
                machineMilk >= CAPCINO_MILK_PER_CUP && machineDisposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            machineWater -= CAPCINO_WATER_PER_CUP;
            machineBeans -= CAPCINO_BEANS_PER_CUP;
            machineMilk -= CAPCINO_MILK_PER_CUP;
            machineMoney += CAPCINO_PRICE_PER_CUP;
            machineDisposableCups -= 1;
        } else {
            checkIngredientsMissing(CAPCINO_WATER_PER_CUP, CAPCINO_MILK_PER_CUP, CAPCINO_BEANS_PER_CUP);
        }
    }

    //Check whether coffee can be made
    public void checkIngredientsMissing(int water, int beans, int milk) {
        if (machineWater < water) {
            System.out.println("Sorry, not enough water");
        } else if (machineMilk < milk) {
            System.out.println("Sorry, not enough milk");
        } else if (machineBeans < beans) {
            System.out.println("Sorry, not enough beans");
        } else if (machineDisposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        }
    }

    //Refill machine ingredients (2 - Fill)
    public void fillMachine(Scanner scanner) {
        System.out.printf("%nWrite how many ml of water you want to add:%n");
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
    public void takeMachineMoney() {
        System.out.printf("%nI gave you $%d%n", machineMoney);
        machineMoney -= machineMoney;
    }

}
