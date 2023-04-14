package com.mashibing.dp.decoratorMMY;


public class Seasoning {

}

class Milk extends Seasoning{

    private Milk(){

    }
    private static final Milk INSTANCE = new Milk();
    public static Milk getInstance() {
        return INSTANCE;
    }

    public String getDescription() {
        return "加一份牛奶";
    }

    public int getCost() {
        return 5;
    }
}
class Taffy extends Seasoning{

    public String getDescription() {
        return "加太妃糖";
    }

    public int getCost() {
        return 6;
    }
}
class Chocolate extends Seasoning{

    private Chocolate(){

    }
    private static final Chocolate INSTANCE = new Chocolate();
    public static Chocolate getInstance() {
        return INSTANCE;
    }
    public String getDescription() {
        return "加巧克力";
    }

    public int getCost() {
        return 7;
    }
}