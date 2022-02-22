package com.LearnJava;

    public class CoffeeApp {
        private static int cupsCoffee;
        private static int qtyWater;
        private static int qtyMilk;
        private static int qtyBeans;

        public CoffeeApp(int cupsCoffee) {
            this.cupsCoffee = cupsCoffee;
            this.qtyWater = cupsCoffee * 200;
            this.qtyMilk = cupsCoffee * 50;
            this.qtyBeans = cupsCoffee * 15;
        }

        public void printIngredients() {
            System.out.printf("For %d cups of coffee you will need:%n", cupsCoffee);
            System.out.printf("%d ml of water%n", qtyWater);
            System.out.printf("%d ml of milk%n", qtyMilk);
            System.out.printf("%d g of coffee beans%n", qtyBeans);
        }
}
