package com.LearnJava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeApp coffeeApp = new CoffeeApp();
        coffeeApp.machineCurrentState();

        System.out.printf("%nWrite action (buy, fill, take):");
        String action = scanner.nextLine();
        coffeeApp.executeAction(action, scanner);
    }
}
