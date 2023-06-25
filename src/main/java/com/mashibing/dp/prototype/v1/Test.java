package com.mashibing.dp.prototype.v1;

/**
 * 浅克隆
 */

public class Test {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        // 如果想要使用clone方法第一要实现Cloneable接口第二要重写Object的clone方法
        Person p2 = (Person)p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        // 引用地址被拷贝过来了 即两个对象的loc引用指向同一个loc对象
        System.out.println(p1.loc == p2.loc);
        // 修改p1的loc的street 会影响到p2
        p1.loc.street = "sh";
        System.out.println(p2.loc);

    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);
    // 重写clone方法将其访问限制修改为public
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location {
    String street;
    int roomNo;

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
