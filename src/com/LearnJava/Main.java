package com.LearnJava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cupsCoffee = scanner.nextInt();
        CoffeeApp coffeeApp = new CoffeeApp(cupsCoffee);
        coffeeApp.printIngredients();
    }
}
