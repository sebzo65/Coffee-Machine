package com.LearnJava;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeApp coffeeApp = new CoffeeApp();
        coffeeApp.executeAction(scanner);
    }
}
