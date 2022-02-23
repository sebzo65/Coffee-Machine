package com.LearnJava;

    public class CoffeeApp {
        private final int cupsCoffee;
        private final int totalWater;
        private final int totalMilk;
        private final int totalBeans;
        private static final int WATER_PER_CUP = 200;
        private static final int MILK_PER_CUP = 50;
        private static final int BEANS_PER_CUP = 15;

        public CoffeeApp(int cupsCoffee, int totalWater, int totalMilk, int totalBeans) {
            this.cupsCoffee = cupsCoffee;
            this.totalWater = totalWater;
            this.totalMilk = totalMilk;
            this.totalBeans = totalBeans;
        }

        public void calculateCoffeeMaking() {
            int cupsWater = totalWater / WATER_PER_CUP;
            int cupsMilk = totalMilk / MILK_PER_CUP;
            int cupsBeans = totalBeans / BEANS_PER_CUP;

            int minCups = Math.min(cupsWater, Math.min(cupsMilk, cupsBeans));

            if (minCups < cupsCoffee) {
                System.out.println("No, I can make only " + minCups + " cup(s) of coffee");
            } else if (minCups == cupsCoffee) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (minCups - cupsCoffee) + " more than that)");
            }

        }
}
