package com.mashibing.dp.prototype.v2;

/**
 * 深克隆的处理
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);



    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        // 让clone出来的Person对象的loc引用，指向loc clone出来的新loc对象
        p.loc = (Location)loc.clone();
        return p;
    }
}

class Location implements Cloneable {
    // String虽然是引用类型，但是它指向常量池，虽然一开始p1p2的street都指向bj但是当修改p1的street为sh时，
    // 不会改变常量池的bj的数值，而是会让p1的street引用指向常量池sh，而p2还是指向bj
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
