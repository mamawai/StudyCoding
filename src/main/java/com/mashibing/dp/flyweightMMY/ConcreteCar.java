package com.mashibing.dp.flyweightMMY;

public class ConcreteCar implements Car{

    private String model;
    private String color;
    private String engine;
    private int horsepower;

    public ConcreteCar(String model){
        this.model = model;
    }
    @Override
    public void configure(String color, String engine, int horsepower) {
        this.color = color;
        this.engine = engine;
        this.horsepower = horsepower;
    }

    @Override
    public void printConfiguration() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Engine: " + engine);
        System.out.println("Horsepower: " + horsepower);
        System.out.println();
    }
}
