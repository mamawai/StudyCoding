package com.mashibing.dp.decoratorMMY;

public class Client {
    public static void main(String[] args) {
        Beverage latteAddDoubleMild = new AddChoc(new AddMilk(new AddMilk(new Latte())));
        int cost = latteAddDoubleMild.getCost();
        System.out.println(cost);
        System.out.println(latteAddDoubleMild.getDescription());

        AddSuger addDoubleSuger = new AddSuger(new AddSuger(new Black()));
        System.out.println(addDoubleSuger.getDescription()+" "+ addDoubleSuger.getCost());
    }
}
