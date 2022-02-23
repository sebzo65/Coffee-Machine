package com.LearnJava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsCoffee = scanner.nextInt();
        CoffeeApp coffeeApp = new CoffeeApp(cupsCoffee, water, milk, beans);
        coffeeApp.calculateCoffeeMaking();
    }
}
