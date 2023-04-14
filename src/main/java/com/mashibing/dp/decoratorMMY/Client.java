package com.mashibing.dp.decoratorMMY;

public class Client {
    public static void main(String[] args) {
        Beverage latteAddDoubleMild = new AddChoc(new AddMilk(new AddMilk(new Latte())));
        int cost = latteAddDoubleMild.getCost();
        System.out.println(cost);
        System.out.println(latteAddDoubleMild.getDescription());
    }
}
